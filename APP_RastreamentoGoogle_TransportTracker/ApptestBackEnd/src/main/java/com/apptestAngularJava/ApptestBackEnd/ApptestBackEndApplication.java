package com.apptestAngularJava.ApptestBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApptestBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApptestBackEndApplication.class, args);
	}
	
	@Bean //Liberando o cors da aplicação
	public WebMvcConfigurer  corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings( CorsRegistry registry ) {
				registry.addMapping("*").allowedOrigins("*");
			}
		};
	}
	
	
	

}
