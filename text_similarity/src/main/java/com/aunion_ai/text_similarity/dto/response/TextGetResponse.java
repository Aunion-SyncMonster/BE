package com.aunion_ai.text_similarity.dto.response;

import com.aunion_ai.text_similarity.entity.TextSimilarityEntity;
import com.aunion_ai.text_similarity.global.enumeration.Language;
import com.aunion_ai.text_similarity.global.enumeration.TaskStatus;
import com.aunion_ai.text_similarity.global.enumeration.TranslationApiType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * packageName    : com.aunion_ai.text_similarity.dto.response<br>
 * fileName       : TextGetResponse.java<br>
 * author         : Fiat_lux<br>
 * date           : 2025-05-08<br>
 * description    :  Test get request  response dto class<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.08         Fiat_lux            최초생성<br>
 */
@Getter
@AllArgsConstructor
@Schema(name = "TextSimilarityGetResponse", description = "Total Project 텍스트 유사도 조회 응답 DTO")
public class TextGetResponse {
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

    @Schema(description = "LabSE 점수", example = "0.70")
    private BigDecimal labse;

    @Schema(description = "BERT 기반 정량 점수", example = "0.923")
    private BigDecimal bertscore;

    @Schema(description = "COMET 기반 정량 점수", example = "0.87")
    private BigDecimal cometScore;

    public static TextGetResponse of(TextSimilarityEntity entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        return new TextGetResponse(
                entity.getId(),
                entity.getTotalProjectId(),
                entity.getScore(),
                entity.getCreatedDate(),
                entity.getInputOriginalText(),
                entity.getOutputTranslationText(),
                entity.getInputOriginalTextKey(),
                entity.getOutputTranslationTextKey(),
                entity.getInputLanguage(),
                entity.getOutputLanguage(),
                entity.getTranslationApiType(),
                entity.getInferenceTime(),
                entity.getStatus(),
                entity.getDescription(),
                entity.getE5(),
                entity.getLabse(),
                entity.getBertscore(),
                entity.getCometScore()
        );
    }
}