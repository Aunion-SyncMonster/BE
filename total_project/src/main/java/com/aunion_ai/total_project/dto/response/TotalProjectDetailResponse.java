package com.aunion_ai.total_project.dto.response;

import com.aunion_ai.total_project.dto.alignment.response.AlignmentSimilarityGetResponse;
import com.aunion_ai.total_project.dto.text.response.TextSimilarityGetResponse;
import com.aunion_ai.total_project.dto.tts.response.TTSNaturalnessGetResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * packageName    : com.aunion_ai.total_project.dto.response<br>
 * fileName       : TotalProjectDetailResponse.java<br>
 * author         : Fiat_lux<br>
 * date           : 2025-05-02<br>
 * description    :  Total Project Detail response dto class<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.02          Fiat_lux           최초생성<br>
 */
@Data
@AllArgsConstructor
public class TotalProjectDetailResponse {
    private TotalProjectGetDetailResponse totalProjectGetDetailResponse;
    private List<TTSNaturalnessGetResponse> ttsNaturalnessGetResponse;
    private List<TextSimilarityGetResponse> textSimilarityGetResponse;
    private List<AlignmentSimilarityGetResponse> alignmentSimilarityGetResponse;
}
