package com.aunion_ai.text_similarity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TextSimilarityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextSimilarityApplication.class, args);
	}

}
