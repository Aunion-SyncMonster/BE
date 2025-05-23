package com.aunion_ai.alignment_similarity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AlignmentSimilarityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlignmentSimilarityApplication.class, args);
	}

}
