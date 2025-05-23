package com.aunion_ai.total_project.dto.text.request;

import com.aunion_ai.total_project.global.enumeration.Language;
import com.aunion_ai.total_project.global.enumeration.TaskStatus;
import com.aunion_ai.total_project.global.enumeration.TranslationApiType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * packageName    : com.aunion_ai.total_project.dto.text.request<br>
 * fileName       : TextSimilarityPostRequest.java <br>
 * author         : chanhoan <br>
 * date           : 25. 4. 30.<br>
 * description    : text_similarity 생성에 사용되는 request dto class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.04.30          chanhoan          최초생성<br>
 */
@Getter
@Setter
@NoArgsConstructor
@Schema(name = "TextSimilarityRegisterRequest", description = "텍스트 유사도 등록 요청 DTO")
public class TextSimilarityRegisterRequest {

    @Schema(description = "전체 프로젝트 식별자", example = "123")
    @NotNull(message = "전체 프로젝트 식별자는 필수입니다.")
    @Min(value = 0, message = "전체 프로젝트 식별자는 최소 0입니다.")
    private Integer totalProjectId;

    @Schema(description = "유사도 점수 (0~100)", example = "85")
    @NotNull(message = "유사도 점수는 필수입니다.")
    @Min(value = 0, message = "유사도 점수는 최소 0입니다.")
    @Max(value = 100, message = "유사도 점수는 최대 100입니다.")
    private Integer score;

    @Schema(description = "입력 텍스트", example = "안녕하세요, 오늘 기분이 어떠세요?")
    @NotBlank(message = "입력 텍스트는 필수입니다.")
    @Size(min = 1, max = 10000, message = "입력 텍스트는 최소 1글자, 최대 10000글자입니다.")
    private String inputText;

    @Schema(description = "번역 텍스트", example = "Hello, how are you feeling today?")
    @NotNull(message = "번역 텍스트는 필수입니다.")
    @Size(min = 0, max = 10000, message = "번역 텍스트는 최대 10000글자입니다.")
    private String translationText;

    @Schema(description = "입력 텍스트 S3 키", example = "text_similarity/task_name_asdfl1354463426/input_text.txt")
    @NotBlank(message = "입력 텍스트 S3 키는 필수입니다.")
    @Size(min = 1, max = 255, message = "입력 텍스트는 최소 1글자, 최대 255글자입니다.")
    private String inputTextKey;

    @Schema(description = "번역 텍스트 S3 키", example = "text_similarity/task_name_asdfl1354463426/output_text.txt")
    @NotBlank(message = "번역 텍스트 S3 키는 필수입니다.")
    @Size(min = 1, max = 255, message = "번역 텍스트는 최대 255글자입니다.")
    private String translationTextKey;

    @Schema(description = "번역기 API 타입", example = "MT5")
    @NotBlank(message = "번역기 API 타입은 필수입니다.")
    @Size(min = 1, max = 6, message = "번역기 API 타입은 최대 6글자입니다.")
    private TranslationApiType translationApiType;

    @Schema(description = "소요된 시간 (초 단위)", example = "0.123")
    @NotNull(message = "소요된 시간은 필수입니다.")
    @PositiveOrZero(message = "소요된 시간은 0 이상이어야 합니다.")
    @Digits(integer = 8, fraction = 2, message = "정수부는 최대 8자리, 소수부는 최대 2자리까지 허용됩니다.")
    private BigDecimal inferenceTime;

    @Schema(description = "작업 상태 (SUCCESS, FAILED)", example = "SUCCESS")
    @NotNull(message = "작업 상태는 필수입니다.")
    @Size(min = 1, max = 6, message = "작업 상태는 최대 6글자입니다.")
    private TaskStatus status;

    @Schema(description = "입력 언어 코드", example = "KOREAN")
    @NotBlank(message = "입력 언어는 필수입니다.")
    @Size(min = 1, max = 7, message = "입력 언어는 최대 7글자입니다.")
    private Language inputLanguage;

    @Schema(description = "출력 언어 코드", example = "ENGLISH")
    @NotBlank(message = "출력 언어는 필수입니다.")
    @Size(min = 1, max = 7, message = "출력 언어는 최대 7글자입니다.")
    private Language outputLanguage;

    @Schema(description = "작업 이름", example = "text_similarity_UUID")
    @NotBlank(message = "작업 이름은 필수입니다.")
    @Size(max = 255, message = "작업 이름은 최대 255글자입니다.")
    private String taskName;

    @Schema(description = "피드백", example = "Score Explanation: ...")
    @NotBlank(message = "피드백은 필수입니다.")
    @Size(max = 10000, message = "피드백은 최대 10000글자입니다.")
    private String description;

    @NotNull(message = "E5 점수는 필수 입력 항목입니다.")
    @Schema(description = "E5 점수", example = "85")
    private Integer e5;

    @NotNull(message = "LabSE 점수는 필수 입력 항목입니다.")
    @Schema(description = "LabSE 점수", example = "78")
    private Integer labse;

    @NotNull(message = "BERTScore는 필수 입력 항목입니다.")
    @Schema(description = "BERT 기반 정량 점수", example = "0.923")
    private BigDecimal bertscore;

    @NotNull(message = "COMET 점수는 필수 입력 항목입니다.")
    @Schema(description = "COMET 기반 정량 점수", example = "87")
    private Integer cometScore;

}
