package br.com.esiggroup.recrutamento.taskmanager.configurations;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://localhost:4200")
		.allowedMethods("GET", "PUT", "PATCH", "POST","HEAD", "OPTIONS");
	}
}
