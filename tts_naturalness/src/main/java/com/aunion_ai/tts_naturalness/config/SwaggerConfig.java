package com.aunion_ai.tts_naturalness.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : com.aunion_ai.module_ttsnaturalness.config<br>
 * fileName       : SwaggerConfig.java<br>
 * author         : Fiat_lux <br>
 * date           : 2025-04-30<br>
 * description    : swagger 관련 설정 클래스입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 2025-04-30        Fiat_lux          최초생성<br>
 * <br>
 */
@OpenAPIDefinition(
        servers = {
                @Server(url = "http://k12s307.p.ssafy.io:8084", description = "tts_naturalness 도메인 서버")
        }
)
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private io.swagger.v3.oas.models.info.Info apiInfo() {
        return new Info()
                .title("TTS Naturalness API")
                .description("tts_naturalness 도메인의 기능을 제공합니다.")
                .version("1.0.0");
    }
}
