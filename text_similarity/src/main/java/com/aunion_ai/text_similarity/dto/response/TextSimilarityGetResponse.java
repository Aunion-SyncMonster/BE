package com.aunion_ai.text_similarity.dto.response;

import com.aunion_ai.text_similarity.entity.TextSimilarityEntity;
import com.aunion_ai.text_similarity.global.enumeration.Language;
import com.aunion_ai.text_similarity.global.enumeration.TaskStatus;
import com.aunion_ai.text_similarity.global.enumeration.TranslationApiType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * packageName    : com.aunion_ai.text_similarity.dto.response<br>
 * fileName       : TextSimilarityGetResponse.java <br>
 * author         : chanhoan <br>
 * date           : 25. 4. 30.<br>
 * description    : text_similarity 조회에 사용되는 response dto class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.04.30          chanhoan          최초생성<br>
 */
@Getter
@AllArgsConstructor
@Builder
@Schema(name = "TextSimilarityGetResponse", description = "텍스트 유사도 조회 응답 DTO")
public class TextSimilarityGetResponse {

    @Schema(description = "유사도 평가 레코드의 고유 식별자", example = "1")
    private Integer id;

    @Schema(description = "전체 프로젝트 식별자", example = "123")
    private Integer totalProjectId;

    @Schema(description = "유사도 점수 (0~100)", example = "85")
    private Integer score;

    @Schema(description = "평가 생성 일시 (yyyy-MM-dd HH:mm:ss)", example = "2025-04-30 21:15:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @Schema(description = "입력 원문 텍스트", example = "안녕하세요, 오늘 기분이 어떠세요?")
    private String inputOriginalText;

    @Schema(description = "출력(번역) 텍스트", example = "Hello, how are you feeling today?")
    private String outputTranslationText;

    @Schema(description = "입력 원문 텍스트 S3 키", example = "text_similarity/task_name_asdfl1354463426/input_text.txt")
    private String inputOriginalTextKey;

    @Schema(description = "출력(번역) 텍스트 S3 키", example = "text_similarity/task_name_asdfl1354463426/output_text.txt")
    private String outputTranslationTextKey;

    @Schema(description = "입력 언어", example = "ENGLISH")
    private Language inputLanguage;

    @Schema(description = "출력 언어", example = "KOREAN")
    private Language outputLanguage;

    @Schema(description = "번역기 API 타입", example = "GOOGLE")
    private TranslationApiType translationApiType;

    @Schema(description = "추론에 소요된 시간(초 단위)", example = "0.123")
    private BigDecimal inferenceTime;

    @Schema(description = "작업 상태 (SUCCESS, FAILED)", example = "SUCCESS")
    private TaskStatus status;

    @Schema(description = "피드백", example = "Score Explanation: ...")
    private String description;

    @Schema(description = "E5 점수", example = "0.85")
    private BigDecimal e5;

    @Schema(description = "LabSE 점수", example = "0.78")
    private BigDecimal labse;

    @Schema(description = "BERT 기반 정량 점수", example = "0.923")
    private BigDecimal bertscore;

    @Schema(description = "COMET 기반 정량 점수", example = "0.87")
    private BigDecimal cometScore;

    public static TextSimilarityGetResponse of(TextSimilarityEntity entity) {
        return TextSimilarityGetResponse.builder()
                .id(entity.getId())
                .totalProjectId(entity.getTotalProjectId())
                .score(entity.getScore())
                .createdDate(entity.getCreatedDate())
                .inputOriginalText(entity.getInputOriginalText())
                .outputTranslationText(entity.getOutputTranslationText())
                .inputOriginalTextKey(entity.getInputOriginalTextKey())
                .outputTranslationTextKey(entity.getOutputTranslationTextKey())
                .inputLanguage(entity.getInputLanguage())
                .outputLanguage(entity.getOutputLanguage())
                .translationApiType(entity.getTranslationApiType())
                .inferenceTime(entity.getInferenceTime())
                .status(entity.getStatus())
                .description(entity.getDescription())
                .e5(entity.getE5())
                .labse(entity.getLabse())
                .bertscore(entity.getBertscore())
                .cometScore(entity.getCometScore())
                .build();
    }

}
