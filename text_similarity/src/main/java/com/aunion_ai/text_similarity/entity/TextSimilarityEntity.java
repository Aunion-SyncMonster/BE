package com.aunion_ai.text_similarity.entity;

import com.aunion_ai.text_similarity.global.entity.BaseEntity;
import com.aunion_ai.text_similarity.global.enumeration.Language;
import com.aunion_ai.text_similarity.global.enumeration.TaskStatus;
import com.aunion_ai.text_similarity.global.enumeration.TranslationApiType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;

/**
 * packageName    : com.aunion_ai.text_similarity.entity <br>
 * fileName       : TextSimilarityEntity.java <br>
 * author         : chanhoan <br>
 * date           : 25. 4. 29.<br>
 * description    : text_similarity entity class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.04.29          chanhoan          최초생성<br>
 * 25.04.30          chanhoan          묘듈로 패키지 변경<br>
 */
@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "text_similarity")
public class TextSimilarityEntity extends BaseEntity {

    @Column(name = "total_project_id", nullable = false)
    private Integer totalProjectId;

    @Min(0)
    @Max(100)
    @Column(name = "score", nullable = false, columnDefinition = "TINYINT UNSIGNED")
    private Integer score;

    @Column(name = "input_original_text", nullable = false, columnDefinition = "TEXT")
    private String inputOriginalText;

    @Column(name = "output_translation_text", nullable = false, columnDefinition = "TEXT")
    private String outputTranslationText;

    @Column(name = "input_original_text_key", nullable = false, columnDefinition = "TEXT")
    private String inputOriginalTextKey;

    @Column(name = "output_translation_text_key", nullable = false, columnDefinition = "TEXT")
    private String outputTranslationTextKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "translation_api_type", nullable = false, length = 6)
    private TranslationApiType translationApiType;

    @Column(name = "inference_time", nullable = false, precision = 10, scale = 2)
    private BigDecimal inferenceTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "input_language", nullable = false, length = 8)
    private Language inputLanguage;

    @Enumerated(EnumType.STRING)
    @Column(name = "output_language", nullable = false, length = 8)
    private Language outputLanguage;

    @Column(name = "task_name", nullable = false, length = 255)
    private String taskName;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "e5", nullable = false, precision = 3, scale = 2)
    private BigDecimal e5;

    @Column(name = "labse", nullable = false, precision = 3, scale = 2)
    private BigDecimal labse;

    @Column(name = "bertscore", nullable = false, precision = 3, scale = 2)
    private BigDecimal bertscore;

    @Column(name = "comet_score", nullable = false, precision = 3, scale = 2)
    private BigDecimal cometScore;

    @Builder
    public TextSimilarityEntity(Integer totalProjectId, Integer score, String inputOriginalText, String outputTranslationText, String inputOriginalTextKey, String outputTranslationTextKey, TranslationApiType translationApiType, BigDecimal inferenceTime, TaskStatus status, Language inputLanguage, Language outputLanguage, String taskName, String description, BigDecimal e5, BigDecimal labse, BigDecimal bertscore, BigDecimal cometScore) {
        this.totalProjectId = totalProjectId;
        this.score = score;
        this.inputOriginalText = inputOriginalText;
        this.outputTranslationText = outputTranslationText;
        this.inputOriginalTextKey = inputOriginalTextKey;
        this.outputTranslationTextKey = outputTranslationTextKey;
        this.translationApiType = translationApiType;
        this.inferenceTime = inferenceTime;
        this.status = status;
        this.inputLanguage = inputLanguage;
        this.outputLanguage = outputLanguage;
        this.taskName = taskName;
        this.description = description;
        this.e5 = e5;
        this.labse = labse;
        this.bertscore = bertscore;
        this.cometScore = cometScore;
    }
}
