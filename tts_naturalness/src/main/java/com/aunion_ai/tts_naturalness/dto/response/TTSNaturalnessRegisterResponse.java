package com.aunion_ai.tts_naturalness.dto.response;

import com.aunion_ai.tts_naturalness.entity.TTSNaturalnessEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * packageName    : com.aunion_ai.tts_naturalness.dto.response<br>
 * fileName       : TTSNaturalnessRegisterResponse.java<br>
 * author         : Fiat_lux <br>
 * date           : 2025-04-30<br>
 * description    : TTSNaturalness post 요청의 response dto class 입니다.<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 2025-04-30        Fiat_lux          최초생성<br>
 * <br>
 */
@Getter
@Builder
@AllArgsConstructor
@Schema(description = "TTS 자연스러움 등록 응답 DTO")
public class TTSNaturalnessRegisterResponse {

    @Schema(description = "등록된 평가 ID", example = "42")
    private Integer id;

    public static TTSNaturalnessRegisterResponse of(TTSNaturalnessEntity entity) {
        return TTSNaturalnessRegisterResponse.builder()
                .id(entity.getId())
                .build();
    }
}
