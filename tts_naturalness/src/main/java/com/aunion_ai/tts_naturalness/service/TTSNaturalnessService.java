package com.aunion_ai.tts_naturalness.service;

import com.aunion_ai.tts_naturalness.dto.request.TTSNaturalnessRegisterRequest;
import com.aunion_ai.tts_naturalness.dto.response.TTSGetResponse;
import com.aunion_ai.tts_naturalness.dto.response.TTSNaturalnessGetResponse;
import com.aunion_ai.tts_naturalness.dto.response.TTSNaturalnessRegisterResponse;
import com.aunion_ai.tts_naturalness.entity.TTSNaturalnessEntity;
import com.aunion_ai.tts_naturalness.global.exception.TTSNaturalnessErrorCode;
import com.aunion_ai.tts_naturalness.repository.TTSNaturalnessRepository;
import com.github.hyeonjaez.springcommon.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * packageName    : com.aunion_ai.tts_naturalness.service<br>
 * fileName       : TTSNaturalnessService.java<br>
 * author         : Fiat_lux <br>
 * date           : 2025-04-30<br>
 * description    : TTSNaturalness 의 비즈니스 로직 service class <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 2025-04-30        Fiat_lux          최초생성<br>
 * <br>
 */
@Service
@Transactional
@RequiredArgsConstructor
public class TTSNaturalnessService {
    private final TTSNaturalnessRepository ttsNaturalnessRepository;

    /**
     * TTS 자연스러움 평가 요청을 등록합니다.
     *
     * @param request 등록할 요청 데이터
     * @return 등록된 TTS 평가 결과에 대한 응답 객체
     */
    public TTSNaturalnessRegisterResponse registerTextSimilarity(TTSNaturalnessRegisterRequest request) {
        TTSNaturalnessEntity ttsNaturalnessEntity = TTSNaturalnessRegisterRequest.to(request);
        return TTSNaturalnessRegisterResponse.of(ttsNaturalnessRepository.save(ttsNaturalnessEntity));
    }

    /**
     * 주어진 taskName을 기반으로 TTS 자연스러움 평가 결과를 조회합니다.
     *
     * @param taskName 조회할 태스크 이름
     * @return 조회된 평가 결과에 대한 응답 객체
     * @throws BusinessException 평가 결과가 존재하지 않을 경우 예외 발생
     */
    @Transactional(readOnly = true)
    public TTSNaturalnessGetResponse getTTSNaturalnessByTaskName(String taskName) {
        TTSNaturalnessEntity ttsNaturalnessEntity = ttsNaturalnessRepository.findByTaskName(taskName)
                .orElseThrow(() -> new BusinessException(TTSNaturalnessErrorCode.TTS_NATURALNESS_NOT_FOUND));

        return TTSNaturalnessGetResponse.of(ttsNaturalnessEntity);
    }

    /**
     * 프로젝트 ID를 기준으로 생성일 오름차순으로 정렬된 TTS 자연스러움 평가 결과 리스트를 조회합니다.
     *
     * @param projectId 총 프로젝트 ID
     * @return 조회된 평가 결과 응답 객체 리스트
     */
    @Transactional(readOnly = true)
    public List<TTSNaturalnessGetResponse> getTTSNaturalnessByProjectIdOrderByCreatedDate(Integer projectId) {
        List<TTSNaturalnessEntity> entityList = ttsNaturalnessRepository.findByTotalProjectIdOrderByCreatedDate(projectId);

        return entityList.stream()
                .map(TTSNaturalnessGetResponse::of)
                .toList();
    }

    /**
     * 프로젝트 ID를 기준으로 가장 최근에 생성된 TTS 자연스러움 평가 결과를 조회합니다.
     *
     * @param totalProjectId 총 프로젝트 ID
     * @return 최신 평가 결과 응답 객체
     */
    @Transactional(readOnly = true)
    public TTSGetResponse getTTSByProjectIdOrderByCreatedDateLimit1(Integer totalProjectId) {
        TTSNaturalnessEntity entity = ttsNaturalnessRepository.findFirstByTotalProjectIdOrderByCreatedDateDesc(totalProjectId);

        return TTSGetResponse.of(entity);
    }

    public void deleteByTotalProjectId(Integer totalProjectId) {
        if (ttsNaturalnessRepository.existsByTotalProjectId(totalProjectId)) {
            ttsNaturalnessRepository.deleteAllByTotalProjectId(totalProjectId);
        }

    }

}
