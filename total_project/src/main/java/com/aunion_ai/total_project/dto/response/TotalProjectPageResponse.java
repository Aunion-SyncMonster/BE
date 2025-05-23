package com.aunion_ai.total_project.dto.response;


import com.aunion_ai.total_project.dto.alignment.response.AlignmentGetResponse;
import com.aunion_ai.total_project.dto.text.response.TextGetResponse;
import com.aunion_ai.total_project.dto.tts.response.TTSGetResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

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
public class TotalProjectPageResponse {
    private TotalProjectGetPageResponse totalProjectGetPageResponse;
    private AlignmentGetResponse alignmentGetResponse;
    private TextGetResponse textGetResponse;
    private TTSGetResponse ttsGetResponse;
}
