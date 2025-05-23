package com.aunion_ai.total_project.entity;

import com.aunion_ai.total_project.global.entity.BaseEntity;
import com.aunion_ai.total_project.global.enumeration.ProjectType;
import com.aunion_ai.total_project.global.enumeration.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName    : com.aunion_ai.total_project.entity<br>
 * fileName       : TotalProjectEntity.java<br>
 * author         : Fiat_lux<br>
 * date           : 2025-04-30<br>
 * description    :  total_project domain entity class<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.04.30          Fiat_lux           최초생성<br>
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "total_project")
public class TotalProjectEntity extends BaseEntity {

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Min(0)
    @Max(100)
    @Column(name = "total_score", nullable = true, columnDefinition = "TINYINT UNSIGNED")
    private Integer totalScore;

    @Column(name = "input_voice_key", nullable = true, columnDefinition = "TEXT")
    private String inputVoiceKey;

    @Column(name = "output_voice_key", nullable = true, columnDefinition = "TEXT")
    private String outputVoiceKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_status", nullable = true, length = 10)
    private TaskStatus projectStatus;

    @Column(name = "text_similarity_score", nullable = true)
    private Integer textSimilarityScore;

    @Column(name = "tts_naturalness_score", nullable = true)
    private Integer ttsNaturalnessScore;

    @Column(name = "alignment_similarity_score", nullable = true)
    private Integer alignmentSimilarityScore;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_type", nullable = false, length = 20)
    private ProjectType projectType;

    @Builder
    public TotalProjectEntity(String title, Integer totalScore, String inputVoiceKey, String outputVoiceKey, TaskStatus projectStatus, Integer textSimilarityScore, Integer ttsNaturalnessScore, Integer alignmentSimilarityScore, ProjectType projectType) {
        this.title = title;
        this.totalScore = totalScore;
        this.inputVoiceKey = inputVoiceKey;
        this.outputVoiceKey = outputVoiceKey;
        this.projectStatus = projectStatus;
        this.textSimilarityScore = textSimilarityScore;
        this.ttsNaturalnessScore = ttsNaturalnessScore;
        this.alignmentSimilarityScore = alignmentSimilarityScore;
        this.projectType = projectType;
    }
}
