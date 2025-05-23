package com.aunion_ai.total_project.service;

import com.aunion_ai.total_project.dto.alignment.response.AlignmentGetResponse;
import com.aunion_ai.total_project.dto.alignment.response.AlignmentSimilarityGetResponse;
import com.aunion_ai.total_project.dto.request.TotalProjectRegisterRequest;
import com.aunion_ai.total_project.dto.request.TotalProjectUpdateRequest;
import com.aunion_ai.total_project.dto.response.*;
import com.aunion_ai.total_project.dto.text.response.TextGetResponse;
import com.aunion_ai.total_project.dto.text.response.TextSimilarityGetResponse;
import com.aunion_ai.total_project.dto.tts.response.TTSGetResponse;
import com.aunion_ai.total_project.dto.tts.response.TTSNaturalnessGetResponse;
import com.aunion_ai.total_project.entity.TotalProjectEntity;
import com.aunion_ai.total_project.global.exception.DomainErrorCode;
import com.aunion_ai.total_project.repository.TotalProjectRepository;
import com.github.hyeonjaez.springcommon.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * packageName    : com.aunion_ai.module_total_project.service<br>
 * fileName       : null.java<br>
 * author         : SSAFY<br>
 * date           : 2025-04-30<br>
 * description    :  <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * <br>
 * <br>
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TotalProjectService {
    private final TotalProjectRepository totalProjectRepository;
    private final WebClientHandler webClientHandler;

    public static final int PAGE_SIZE = 7;

    public TotalProjectRegisterResponse registerTotalProject(TotalProjectRegisterRequest request) {

        TotalProjectEntity totalProject = TotalProjectEntity.builder()
                .title(request.getTitle())
                .projectType(request.getProjectType())
                .build();

        TotalProjectEntity saveTotalProject = totalProjectRepository.save(totalProject);

        return new TotalProjectRegisterResponse(saveTotalProject.getId(), saveTotalProject.getTitle());
    }

    public TotalProjectRegisterResponse updateTotalProject(TotalProjectUpdateRequest request) {

        TotalProjectEntity existEntity = totalProjectRepository.findById(request.getId())
                .orElseThrow(() -> new BusinessException(DomainErrorCode.TOTAL_PROJECT_NOT_FOUND));

        existEntity.setTotalScore(request.getTotalScore());
        existEntity.setInputVoiceKey(request.getInputVoiceKey());
        existEntity.setOutputVoiceKey(request.getOutputVoiceKey());
        existEntity.setProjectStatus(request.getProjectStatus());
        existEntity.setTextSimilarityScore(request.getTextSimilarityScore());
        existEntity.setTtsNaturalnessScore(request.getTtsNaturalnessScore());
        existEntity.setAlignmentSimilarityScore(request.getAlignmentSimilarityScore());
        existEntity.setProjectType(request.getProjectType());

        TotalProjectEntity updatedEntity = totalProjectRepository.save(existEntity);

        return new TotalProjectRegisterResponse(updatedEntity.getId(), updatedEntity.getTitle());
    }

    @Transactional(readOnly = true)
    public TotalProjectDetailResponse getTotalProjectDetailById(Integer id) {
        TotalProjectEntity totalProject = totalProjectRepository.findById(id).orElseThrow();

        TotalProjectGetDetailResponse totalProjectResponse = TotalProjectGetDetailResponse.of(totalProject);

        log.info("totalProjectResponse: {}", totalProjectResponse.toString());

        List<AlignmentSimilarityGetResponse> alignmentResponse = webClientHandler.requestGetAlignmentListByTotalProjectId(totalProject.getId());
        log.info("alignmentResponse: {}", alignmentResponse.toString());
        List<TextSimilarityGetResponse> textResponse = webClientHandler.requestGetTextListByTotalProjectId(totalProject.getId());
        log.info("textResponse: {}", textResponse.toString());
        List<TTSNaturalnessGetResponse> ttsResponse = webClientHandler.requestGetTTSListByTotalProjectId(totalProject.getId());
        log.info("ttsResponse: {}", ttsResponse.toString());

        return new TotalProjectDetailResponse(totalProjectResponse, ttsResponse, textResponse, alignmentResponse);
    }

    @Transactional(readOnly = true)
    public Page<TotalProjectPageResponse> getTotalProjectPageResponse(int page) {
        PageRequest pageable = PageRequest.of(page, PAGE_SIZE, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<TotalProjectEntity> pageEntity = totalProjectRepository.findAll(pageable);

        List<TotalProjectPageResponse> content = pageEntity.getContent().stream()
                .map(entity -> {
                    TextGetResponse text = webClientHandler.requestGetTextByTotalProjectId(entity.getId());
                    TTSGetResponse tts = webClientHandler.requestGetTTSByTotalProjectId(entity.getId());
                    AlignmentGetResponse alignment = webClientHandler.requestGetAlignmentByTotalProjectId(entity.getId());

                    return new TotalProjectPageResponse(
                            TotalProjectGetPageResponse.of(entity),
                            alignment,
                            text,
                            tts
                    );
                })
                .toList();

        return new PageImpl<>(content, pageable, pageEntity.getTotalElements());
    }

    public void deleteTotalProject(Integer id) {
        if (!totalProjectRepository.existsById(id)) {
            throw new BusinessException(DomainErrorCode.TOTAL_PROJECT_NOT_FOUND);
        }

        webClientHandler.requestDeleteTextByTotalProjectId(id);
        webClientHandler.requestDeleteTTSByTotalProjectId(id);
        webClientHandler.requestDeleteAlignmentByTotalProjectId(id);

        totalProjectRepository.deleteById(id);

    }

}
