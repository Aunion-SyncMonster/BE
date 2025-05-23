package com.aunion_ai.alignment_similarity.entity;

import com.aunion_ai.alignment_similarity.global.entity.BaseEntity;
import com.aunion_ai.alignment_similarity.global.enumeration.Language;
import com.aunion_ai.alignment_similarity.global.enumeration.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * packageName    : com.aunion_ai.alignment_similarity.entity <br>
 * fileName       : AlignmentSimilarityEntity.java <br>
 * author         : chanhoan <br>
 * date           : 25. 5. 01.<br>
 * description    : alignment_similarity entity class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.01          chanhoan          최초생성<br>
 */
@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "alignment_similarity")
public class AlignmentSimilarityEntity extends BaseEntity {

    @Column(name = "total_project_id", nullable = false)
    private Integer totalProjectId;

    @Column(name = "input_original_voice_key", nullable = false, columnDefinition = "TEXT")
    private String inputOriginalVoiceKey;

    @Column(name = "input_original_text_key", nullable = false, columnDefinition = "TEXT")
    private String inputOriginalTextKey;

    @Column(name = "result_compound_voice_key", nullable = false, columnDefinition = "TEXT")
    private String resultCompoundVoiceKey;

    @Column(name = "result_compound_text_key", nullable = false, columnDefinition = "TEXT")
    private String resultCompoundTextKey;

    @Column(name = "inference_time", nullable = false, precision = 10, scale = 2)
    private BigDecimal inferenceTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 6)
    private TaskStatus status;

    @Column(name = "task_name", nullable = false, length = 255)
    private String taskName;

    @Column(name = "audio_comparison_key", nullable = false, columnDefinition = "TEXT")
    private String audioComparisonKey;

    @Column(name = "overall_score", nullable = false, precision = 3, scale = 2)
    private BigDecimal overallScore;

    @Column(length = 1, nullable = false)
    private String grade;

    @Column(name = "pause_similarity", precision = 3, scale = 2, nullable = false)
    private BigDecimal pauseSimilarity;

    @Column(name = "pitch_similarity", precision = 3, scale = 2, nullable = false)
    private BigDecimal pitchSimilarity;

    @Column(name = "energy_similarity", precision = 3, scale = 2, nullable = false)
    private BigDecimal energySimilarity;

    @Column(name = "rhythm_similarity", precision = 3, scale = 2, nullable = false)
    private BigDecimal rhythmSimilarity;

    @Column(name = "vowel_similarity", precision = 3, scale = 2, nullable = false)
    private BigDecimal vowelSimilarity;

    @Column(name = "text_similarity", precision = 3, scale = 2, nullable = false)
    private BigDecimal textSimilarity;

    @Column(name = "temporal_similarity", precision = 3, scale = 2, nullable = false)
    private BigDecimal temporalSimilarity;

    @Column(name = "speaking_rate_similarity", precision = 3, scale = 2, nullable = false)
    private BigDecimal speakingRateSimilarity;

    @Column(name = "prosody_overall_score", precision = 3, scale = 2, nullable = false)
    private BigDecimal prosodyOverallScore;

    @Column(name = "alignment_overall_score", precision = 3, scale = 2, nullable = false)
    private BigDecimal alignmentOverallScore;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "input_language", nullable = false, length = 8)
    private Language inputLanguage;

    @Enumerated(EnumType.STRING)
    @Column(name = "output_language", nullable = false, length = 8)
    private Language outputLanguage;

    @Builder
    public AlignmentSimilarityEntity(Integer totalProjectId, String inputOriginalVoiceKey, String inputOriginalTextKey, String resultCompoundVoiceKey, String resultCompoundTextKey, BigDecimal inferenceTime, TaskStatus status, String taskName, String audioComparisonKey, BigDecimal overallScore, String grade, BigDecimal pauseSimilarity, BigDecimal pitchSimilarity, BigDecimal energySimilarity, BigDecimal rhythmSimilarity, BigDecimal vowelSimilarity, BigDecimal textSimilarity, BigDecimal temporalSimilarity, BigDecimal speakingRateSimilarity, BigDecimal prosodyOverallScore, BigDecimal alignmentOverallScore, String description, Language inputLanguage, Language outputLanguage) {
        this.totalProjectId = totalProjectId;
        this.inputOriginalVoiceKey = inputOriginalVoiceKey;
        this.inputOriginalTextKey = inputOriginalTextKey;
        this.resultCompoundVoiceKey = resultCompoundVoiceKey;
        this.resultCompoundTextKey = resultCompoundTextKey;
        this.inferenceTime = inferenceTime;
        this.status = status;
        this.taskName = taskName;
        this.audioComparisonKey = audioComparisonKey;
        this.overallScore = overallScore;
        this.grade = grade;
        this.pauseSimilarity = pauseSimilarity;
        this.pitchSimilarity = pitchSimilarity;
        this.energySimilarity = energySimilarity;
        this.rhythmSimilarity = rhythmSimilarity;
        this.vowelSimilarity = vowelSimilarity;
        this.textSimilarity = textSimilarity;
        this.temporalSimilarity = temporalSimilarity;
        this.speakingRateSimilarity = speakingRateSimilarity;
        this.prosodyOverallScore = prosodyOverallScore;
        this.alignmentOverallScore = alignmentOverallScore;
        this.description = description;
        this.inputLanguage = inputLanguage;
        this.outputLanguage = outputLanguage;
    }
}

