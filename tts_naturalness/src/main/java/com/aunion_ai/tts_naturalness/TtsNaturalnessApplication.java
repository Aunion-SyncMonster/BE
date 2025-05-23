package com.aunion_ai.tts_naturalness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TtsNaturalnessApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtsNaturalnessApplication.class, args);
	}

}
