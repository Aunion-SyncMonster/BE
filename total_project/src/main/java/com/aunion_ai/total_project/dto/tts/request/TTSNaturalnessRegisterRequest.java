package com.aunion_ai.total_project.dto.tts.request;

import com.aunion_ai.total_project.global.enumeration.TTSApiType;
import com.aunion_ai.total_project.global.enumeration.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * packageName    : com.aunion_ai.total_project.dto.tts.request<br>
 * fileName       : TTSNaturalnessRegisterRequest.java<br>
 * author         : Fiat_lux <br>
 * date           : 2025-04-30<br>
 * description    : TTSNaturalness request dto class 입니다.<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 2025-04-30        Fiat_lux          최초생성<br>
 * <br>
 */
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "TTS 자연스러움 등록 요청 DTO")
public class TTSNaturalnessRegisterRequest {

    @Schema(description = "총 프로젝트 ID", example = "1")
    @Min(1)
    private Integer totalProjectId;

    @Schema(description = "입력 오디오 파일 S3 Key", example = "tts_naturalness/tts_naturalness/joker_movie.mp3")
    @NotBlank
    private String inputOriginalKey;

    @Schema(description = "번역된 텍스트 결과 S3 Key", example = "tts_naturalness/tts_naturalness/translated.txt")
    @NotBlank
    private String resultTranslationTextKey;

    @Schema(description = "출력 TTS 파일 S3 Key", example = "tts_naturalness/tts_naturalness/translated_video_tts_naturalness.mp3")
    @NotBlank
    private String outputVoiceKey;

    @Schema(description = "MOS 점수", example = "4")
    @NotNull
    @Min(1)
    private BigDecimal mosScore;

    @Schema(description = "SC 점수", example = "3")
    @NotNull
    @Min(1)
    private BigDecimal scScore;

    @Schema(description = "TTS API 타입", example = "CLOVA")
    @NotBlank
    private TTSApiType ttsApiType;

    @Schema(description = "추론 시간 (초)", example = "1.23")
    @NotNull
    private BigDecimal inferenceTime;

    @Schema(description = "작업 상태", example = "COMPLETED")
    @NotBlank
    private TaskStatus status;

    @Schema(description = "태스크 이름", example = "tts-task-202504301200")
    @NotBlank
    private String taskName;

    @Schema(description = "음성 안정성", example = "0.98")
    @NotNull
    private BigDecimal stability;

    @Schema(description = "유사도 부스트 수준", example = "0.50")
    @NotNull
    private BigDecimal similarityBoost;

    @Schema(description = "음성 스타일", example = "0.75")
    @NotNull
    private BigDecimal style;

    @Schema(description = "스피커 부스트 사용 여부")
    @NotNull
    private Boolean useSpeakerBoost;

    @Schema(description = "고유 음성 아이디", example = "Chi")
    @NotNull
    private String voiceId;

}
