package com.aunion_ai.alignment_similarity.service;

import com.aunion_ai.alignment_similarity.dto.request.AlignmentSimilarityRegisterRequest;
import com.aunion_ai.alignment_similarity.dto.response.AlignmentGetResponse;
import com.aunion_ai.alignment_similarity.dto.response.AlignmentSimilarityGetResponse;
import com.aunion_ai.alignment_similarity.dto.response.AlignmentSimilarityRegisterResponse;
import com.aunion_ai.alignment_similarity.entity.AlignmentSimilarityEntity;
import com.aunion_ai.alignment_similarity.global.exception.AlignmentSimilarityErrorCode;
import com.aunion_ai.alignment_similarity.repository.AlignmentSimilarityRepository;
import com.github.hyeonjaez.springcommon.exception.BusinessException;
import com.github.hyeonjaez.springcommon.util.ObjectsUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * packageName    : com.aunion_ai.alignment_similarity.service <br>
 * fileName       : AlignmentSimilarityService.java <br>
 * author         : chanhoan <br>
 * date           : 25. 5. 01.<br>
 * description    : alignment_similarity service class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.01          chanhoan          최초생성<br>
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AlignmentSimilarityService {

    private final AlignmentSimilarityRepository alignmentSimilarityRepository;

    /**
     * Alignment 유사도를 등록합니다.
     *
     * @param request 등록할 Alignment 유사도 정보를 담은 요청 객체
     * @return 등록된 Alignment 유사도 정보를 담은 응답 객체
     */
    public AlignmentSimilarityRegisterResponse registerAlignmentSimilarity(AlignmentSimilarityRegisterRequest request) {

        AlignmentSimilarityEntity alignmentSimilarity = AlignmentSimilarityRegisterRequest.toAlignmentSimilarityEntity(request);

        return AlignmentSimilarityRegisterResponse.of(alignmentSimilarityRepository.save(alignmentSimilarity));
    }

    /**
     * 주어진 작업 이름(taskName)에 해당하는 Alignment 유사도 정보를 조회합니다.
     *
     * @param taskName 조회할 Alignment 유사도가 속한 작업 이름
     * @return 조회된 Alignment 유사도 정보를 담은 응답 객체
     * @throws BusinessException 해당 작업 이름으로 Alignment 유사도 정보를 찾을 수 없는 경우 발생
     */
    @Transactional(readOnly = true)
    public AlignmentSimilarityGetResponse getAlignmentSimilarity(String taskName) {

        ObjectsUtil.checkNotNull(taskName);

        AlignmentSimilarityEntity alignmentSimilarity = alignmentSimilarityRepository.findByTaskName(taskName)
                .orElseThrow(() -> new BusinessException(AlignmentSimilarityErrorCode.ALIGNMENT_SIMILARITY_NOT_FOUND));

        return AlignmentSimilarityGetResponse.of(alignmentSimilarity);
    }

    /**
     * 프로젝트 ID를 기준으로 Alignment 유사도 평가 결과 목록을 조회합니다.
     * 생성일 오름차순으로 정렬됩니다.
     *
     * @param totalProjectId 총 프로젝트 ID
     * @return Alignment 유사도 평가 응답 리스트
     */
    @Transactional(readOnly = true)
    public List<AlignmentSimilarityGetResponse> getAlignmentSimilarityByTotalProjectId(Integer totalProjectId) {
        List<AlignmentSimilarityEntity> entityList =
                alignmentSimilarityRepository.findByTotalProjectIdOrderByCreatedDate(totalProjectId);

        return entityList.stream()
                .map(AlignmentSimilarityGetResponse::of)
                .toList();
    }

    /**
     * 프로젝트 ID를 기준으로 가장 최근에 등록된 Alignment 유사도 평가 결과 1건을 조회합니다.
     *
     * @param totalProjectId 총 프로젝트 ID
     * @return 최신 Alignment 유사도 평가 응답 객체
     */
    @Transactional(readOnly = true)
    public AlignmentGetResponse getAlignmentByTotalProjectIdOrderByCreatedDateLimit1(Integer totalProjectId) {
        AlignmentSimilarityEntity entity =
                alignmentSimilarityRepository.findFirstByTotalProjectIdOrderByCreatedDateDesc(totalProjectId);

        return AlignmentGetResponse.of(entity);
    }

    public void deleteByTotalProjectId(Integer totalProjectId) {
        if (alignmentSimilarityRepository.existsByTotalProjectId(totalProjectId)) {
            alignmentSimilarityRepository.deleteAllByTotalProjectId(totalProjectId);
        }

    }
}
