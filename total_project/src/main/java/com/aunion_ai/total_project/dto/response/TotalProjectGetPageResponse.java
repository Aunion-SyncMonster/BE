package com.aunion_ai.total_project.dto.response;

import com.aunion_ai.total_project.entity.TotalProjectEntity;
import com.aunion_ai.total_project.global.enumeration.ProjectType;
import com.aunion_ai.total_project.global.enumeration.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * packageName    : com.aunion_ai.total_project.dto.response<br>
 * fileName       : null.java<br>
 * author         : SSAFY<br>
 * date           : 2025-05-08<br>
 * description    :  <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * <br>
 * <br>
 */
@Getter
@AllArgsConstructor
public class TotalProjectGetPageResponse {

    private Integer totalProjectId;

    private String title;

    private Integer totalScore;

    private String inputVoiceKey;

    private String outputVoiceKey;

    private TaskStatus projectStatus;

    private Integer textSimilarityScore;

    private Integer ttsNaturalnessScore;

    private Integer alignmentSimilarityScore;

    private ProjectType projectType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    public static TotalProjectGetPageResponse of(TotalProjectEntity entity) {
        return new TotalProjectGetPageResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getTotalScore(),
                entity.getInputVoiceKey(),
                entity.getOutputVoiceKey(),
                entity.getProjectStatus(),
                entity.getTextSimilarityScore(),
                entity.getTtsNaturalnessScore(),
                entity.getAlignmentSimilarityScore(),
                entity.getProjectType(),
                entity.getCreatedDate()
        );
    }
}
