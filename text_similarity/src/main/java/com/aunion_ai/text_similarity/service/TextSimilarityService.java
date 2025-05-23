package com.aunion_ai.text_similarity.service;

import com.aunion_ai.text_similarity.dto.request.TextSimilarityRegisterRequest;
import com.aunion_ai.text_similarity.dto.response.TextGetResponse;
import com.aunion_ai.text_similarity.dto.response.TextSimilarityGetResponse;
import com.aunion_ai.text_similarity.dto.response.TextSimilarityRegisterResponse;
import com.aunion_ai.text_similarity.entity.TextSimilarityEntity;
import com.aunion_ai.text_similarity.global.exception.TextSimilarityErrorCode;
import com.aunion_ai.text_similarity.repository.TextSimilarityRepository;
import com.github.hyeonjaez.springcommon.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * packageName    : com.aunion_ai.text_similarity.service <br>
 * fileName       : TextSimilarityService.java <br>
 * author         : chanhoan <br>
 * date           : 25. 4. 30.<br>
 * description    : text_similarity service class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.04.30          chanhoan          최초생성<br>
 */
@Service
@Transactional
@RequiredArgsConstructor
public class TextSimilarityService {

    private final TextSimilarityRepository textSimilarityRepository;

    /**
     * 텍스트 유사성 정보를 등록합니다.
     *
     * @param request 등록할 텍스트 유사성 정보 요청 객체
     * @return 등록된 텍스트 유사성 정보 응답 객체
     * @author chanhoan
     */
    public TextSimilarityRegisterResponse registerTextSimilarity(TextSimilarityRegisterRequest request) {

        TextSimilarityEntity textSimilarity = TextSimilarityRegisterRequest.toTextSimilarityEntity(request);

        return TextSimilarityRegisterResponse.of(textSimilarityRepository.save(textSimilarity));
    }

    /**
     * 작업 이름으로 텍스트 유사성 정보를 조회합니다.
     *
     * @param taskName 조회할 작업 이름
     * @return 조회된 텍스트 유사성 정보 응답 객체
     * @throws BusinessException 텍스트 유사성 정보가 없을 경우 발생하는 예외
     */
    @Transactional(readOnly = true)
    public TextSimilarityGetResponse getTextSimilarity(String taskName) {

        TextSimilarityEntity entity = textSimilarityRepository.findByTaskName(taskName)
                .orElseThrow(() -> new BusinessException(TextSimilarityErrorCode.TEXT_SIMILARITY_NOT_FOUND));

        return TextSimilarityGetResponse.of(entity);
    }

    /**
     * 프로젝트 ID를 기준으로 생성일자를 오름차순 정렬하여
     * 텍스트 유사성 정보 리스트를 조회합니다.
     *
     * @param totalProjectId 총 프로젝트 ID
     * @return 텍스트 유사성 정보 응답 객체 리스트
     */
    @Transactional(readOnly = true)
    public List<TextSimilarityGetResponse> getTextSimilarityByTotalProjectIdOrderByCreatedDate(Integer totalProjectId) {
        List<TextSimilarityEntity> entityList = textSimilarityRepository.findByTotalProjectIdOrderByCreatedDate(totalProjectId);


        return entityList.stream()
                .map(TextSimilarityGetResponse::of)
                .toList();
    }

    /**
     * 총 프로젝트 ID를 기준으로 가장 최근에 생성된
     * 텍스트 유사성 정보를 조회합니다.
     *
     * @param totalProjectId 총 프로젝트 ID
     * @return 가장 최근 생성된 텍스트 유사성 정보 응답 객체
     */
    @Transactional(readOnly = true)
    public TextGetResponse getTextByTotalProjectOrderByCreatedDateLimit1(Integer totalProjectId) {
        TextSimilarityEntity entity = textSimilarityRepository.findFirstByTotalProjectIdOrderByCreatedDateDesc(totalProjectId);

        return TextGetResponse.of(entity);
    }

    public void deleteByTotalProjectId(Integer totalProjectId) {
        if (textSimilarityRepository.existsByTotalProjectId(totalProjectId)) {
            textSimilarityRepository.deleteAllByTotalProjectId(totalProjectId);
        }

    }
}
