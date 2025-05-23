package com.aunion_ai.total_project.dto.request;

import com.aunion_ai.total_project.global.enumeration.ProjectType;
import com.aunion_ai.total_project.global.enumeration.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName    : com.aunion_ai.total_project.dto.request<br>
 * fileName       : TotalProjectRegisterRequest.java<br>
 * author         : Fiat_lux<br>
 * date           : 2025-05-02<br>
 * description    :  Total Project Register Request dto class<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.02           Fiat_lux          최초생성<br>
 */
@Getter
@Setter
@NoArgsConstructor
public class TotalProjectUpdateRequest {

    @Schema(description = "전체 프로젝트 식별자", example = "123")
    @NotNull(message = "전체 프로젝트 식별자는 필수입니다")
    @Min(value = 0, message = "전체 프로젝트 식별자는 최소 0입니다.")
    private Integer id;

    @Schema(description = "전체 점수", example = "100")
    @NotNull(message = "전체 점수는 필수입니다.")
    @Size(min = 0, max = 100, message = "전체 점수는 최대 100입니다.")
    private Integer totalScore;

    @Schema(description = "입력 보이스 S3 Key", example = "input_voice.mp3")
    @NotBlank(message = "입력 보이스 S3 Key는 필수입니다.")
    @Size(max = 255, message = "입력 보이스 S3 Key는 최대 255글자입니다.")
    private String inputVoiceKey;

    @Schema(description = "출력 보이스 S3 Key", example = "output_voice.mp3")
    @NotBlank(message = "출력 보이스 S3 Key는 필수입니다.")
    @Size(max = 255, message = "출력 보이스 S3 Key는 최대 255글자입니다.")
    private String outputVoiceKey;

    @Schema(description = "텍스트 유사도 점수", example = "85")
    @NotNull(message = "텍스트 유사도 점수는 필수입니다.")
    @Size(min = 0, max = 100, message = "텍스트 유사도 점수는 최대 100입니다.")
    private Integer textSimilarityScore;

    @Schema(description = "TTS 자연스러움 점수", example = "85")
    @NotNull(message = "TTS 자연스러움 점수는 필수입니다.")
    @Size(min = 0, max = 100, message = "TTS 자연스러움 점수는 최대 100입니다.")
    private Integer ttsNaturalnessScore;

    @Schema(description = "Alignment 유사도 점수", example = "85")
    @NotNull(message = "Alignment 유사도 점수는 필수입니다")
    @Size(min = 0, max = 100, message = "Alignment 유사도 점수는 최대 100입니다.")
    private Integer alignmentSimilarityScore;

    @Schema(description = "프로젝트 상태", example = "SUCCESS")
    @NotBlank(message = "프로젝트 상태는 필수입니다.")
    @Size(min = 1, max = 6, message = "프로젝트 상태는 최대 6 글자입니다.")
    private TaskStatus projectStatus;

    @NotBlank
    private ProjectType projectType;

}
