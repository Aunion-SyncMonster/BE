package com.aunion_ai.alignment_similarity.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

/**
 * packageName    : com.aunion_ai.module_alignment_similarity.config <br>
 * fileName       : SwaggerConfig.java <br>
 * author         : chanhoan <br>
 * date           : 25. 5. 01.<br>
 * description    : Swagger 설정을 위한 config class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.01          chanhoan          최초생성<br>
 */
@OpenAPIDefinition(
        servers = {
                @Server(url = "http://k12s307.p.ssafy.io:8083", description = "alignment_similarity 도메인 서버")
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

    private Info apiInfo() {
        return new Info()
                .title("Alignment Similarity API")
                .description("alignment_similarity 도메인의 기능을 제공합니다.")
                .version("1.0.0");
    }
}
