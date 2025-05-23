package com.aunion_ai.total_project.dto.tts.response;

import com.aunion_ai.total_project.global.enumeration.TTSApiType;
import com.aunion_ai.total_project.global.enumeration.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * packageName    : com.aunion_ai.total_project.dto.tts.response<br>
 * fileName       : TTSNaturalnessGetResponse.java<br>
 * author         : Fiat_lux <br>
 * date           : 2025-04-30<br>
 * description    : TTS 자연스러움 평가 결과 조회 응답을 담는 DTO 클래스입니다.<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 2025-04-30        Fiat_lux          최초생성<br>
 */
@Getter
@Builder
@AllArgsConstructor
@Schema(description = "TTS 자연스러움 평가 결과 응답 DTO")
@ToString
public class TTSNaturalnessGetResponse {

    @Schema(description = "평가 ID", example = "42")
    private Integer id;

    @Schema(description = "총 프로젝트 ID", example = "1")
    private Integer totalProjectId;

    @Schema(description = "입력 오디오 파일 S3 Key", example = "tts_naturalness/tts_naturalness/joker_movie.mp3")
    private String inputOriginalKey;

    @Schema(description = "번역된 텍스트 결과 S3 Key", example = "tts_naturalness/tts_naturalness/translated.txt")
    private String resultTranslationTextKey;

    @Schema(description = "출력 TTS 파일 S3 Key", example = "tts_naturalness/tts_naturalness/translated_video_tts_naturalness.mp3")
    private String outputVoiceKey;

    @Schema(description = "MOS 점수", example = "4")
    private BigDecimal mosScore;

    @Schema(description = "SC 점수", example = "3")
    private BigDecimal scScore;

    @Schema(description = "TTS API 타입", example = "KAKAO")
    private TTSApiType ttsApiType;

    @Schema(description = "추론 시간 (초)", example = "1.23")
    private BigDecimal inferenceTime;

    @Schema(description = "작업 상태", example = "COMPLETED")
    private TaskStatus status;

    @Schema(description = "태스크 이름", example = "tts-task-202504301200")
    private String taskName;

    @Schema(description = "생성 일시", example = "2025-04-30 12:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @Schema(description = "음성 안정성", example = "0.98")
    private BigDecimal stability;

    @Schema(description = "유사도 부스트 수준", example = "0.50")
    private BigDecimal similarityBoost;

    @Schema(description = "음성 스타일", example = "0.75")
    private BigDecimal style;

    @Schema(description = "스피커 부스트 사용 여부")
    private Boolean useSpeakerBoost;

    @Schema(description = "고유 음성 아이디", example = "Chi")
    private String voiceId;

}
