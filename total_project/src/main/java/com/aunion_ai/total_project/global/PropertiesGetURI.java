package com.aunion_ai.total_project.global;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : com.aunion_ai.total_project.global<br>
 * fileName       : PropertiesGetURI.java<br>
 * author         : Fiat_lux<br>
 * date           : 2025-05-08<br>
 * description    :  외부 시스템 호출을 위한 URI 설정 값을 주입받는 설정 클래스입니다.<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.08          Fiat_lux           최초생성<br>
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "request.uri")
public class PropertiesGetURI {
    private TextURI text;
    private AlignmentURI alignment;
    private TTSURI tts;

    @Getter
    @Setter
    public static class TextURI {
        private String post;
        private String get;
    }

    @Getter
    @Setter
    public static class AlignmentURI {
        private String post;
        private String get;
    }

    @Getter
    @Setter
    public static class TTSURI {
        private String post;
        private String get;
    }
}

