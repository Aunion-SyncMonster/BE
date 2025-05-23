package com.aunion_ai.text_similarity.dto.response;

import com.aunion_ai.text_similarity.entity.TextSimilarityEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * packageName    : com.aunion_ai.text_similarity.dto.response <br>
 * fileName       : TextSimilarityPostResponse.java <br>
 * author         : chanhoan <br>
 * date           : 25. 4. 30.<br>
 * description    : text_similarity 생성 후 응답에 사용되는 response dto class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.04.30          chanhoan          최초생성<br>
 */
@Getter
@AllArgsConstructor
@Builder
@Schema(name = "TextSimilarityRegisterResponse", description = "텍스트 유사도 등록 응답 DTO")
public class TextSimilarityRegisterResponse {

    @Schema(description = "등록된 유사도 평가 레코드의 고유 식별자", example = "1")
    private Integer id;

    public static TextSimilarityRegisterResponse of(TextSimilarityEntity entity) {
        return TextSimilarityRegisterResponse.builder()
                .id(entity.getId())
                .build();
    }
}
