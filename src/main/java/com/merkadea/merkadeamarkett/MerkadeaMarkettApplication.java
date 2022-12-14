package com.merkadea.merkadeamarkett;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MerkadeaMarkettApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerkadeaMarkettApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
				//registry.addMapping("/**").allowedOrigins("https://merkadea-market.web.app/");

			}
		};
	}

}
