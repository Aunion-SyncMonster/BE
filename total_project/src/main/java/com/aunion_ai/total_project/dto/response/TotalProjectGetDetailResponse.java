package com.aunion_ai.total_project.dto.response;

import com.aunion_ai.total_project.entity.TotalProjectEntity;
import com.aunion_ai.total_project.global.enumeration.ProjectType;
import com.aunion_ai.total_project.global.enumeration.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * packageName    : com.aunion_ai.total_project.dto.response<br>
 * fileName       : TotalProjectGetDetailResponse.java<br>
 * author         : Fiat_lux<br>
 * date           : 2025-05-02<br>
 * description    :  Total Project get 요청 detail response dto class<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.02          Fiat_lux           최초생성<br>
 */
@Getter
@AllArgsConstructor
@ToString
public class TotalProjectGetDetailResponse {

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

    public static TotalProjectGetDetailResponse of(TotalProjectEntity entity) {
        return new TotalProjectGetDetailResponse(
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
