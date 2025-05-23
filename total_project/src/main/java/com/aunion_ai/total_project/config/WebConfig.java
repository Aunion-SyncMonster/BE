package com.aunion_ai.total_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * packageName    : com.aunion_ai.total_project.config<br>
 * fileName       : WebConfig.java<br>
 * author         : Fiat_lux<br>
 * date           : 2025-05-08<br>
 * description    :  WebClient 설정을 위한 Configuration 클래스입니다.<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.08          Fiat_lux            최초생성<br>
 */
public class WebConfig {

    /**
     * WebClient.Builder Bean을 생성합니다.
     * <p>
     * 의존성 주입을 통해 각 서비스 클래스에서 WebClient 인스턴스를 유연하게 구성할 수 있습니다.
     * </p>
     *
     * @return WebClient.Builder 인스턴스
     */
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
