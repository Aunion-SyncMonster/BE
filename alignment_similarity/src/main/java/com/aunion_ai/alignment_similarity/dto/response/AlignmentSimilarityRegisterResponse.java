package com.aunion_ai.alignment_similarity.dto.response;

import com.aunion_ai.alignment_similarity.entity.AlignmentSimilarityEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * packageName    : com.aunion_ai.alignment_similarity.dto.response <br>
 * fileName       : AlignmentSimilarityRegisterResponse.java <br>
 * author         : chanhoan <br>
 * date           : 25. 5. 01.<br>
 * description    : alignment_similarity 생성 후 응답에 사용되는 response dto class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.01          chanhoan          최초생성<br>
 */
@Getter
@AllArgsConstructor
@Builder
@Schema(name = "AlignmentSimilarityRegisterResponse", description = "Alignment 유사도 등록 응답 DTO")
public class AlignmentSimilarityRegisterResponse {

    @Schema(name = "생성된 Alignment 유사도의 고유 식별자", example = "123")
    private Integer id;

    public static AlignmentSimilarityRegisterResponse of(AlignmentSimilarityEntity entity) {
        return AlignmentSimilarityRegisterResponse.builder()
                .id(entity.getId())
                .build();
    }
}
