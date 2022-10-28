package com.apptestAngularJava.ApptestBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = { "com.apptestAngularJava.ApptestBackEnd.model" })
@ComponentScan(basePackages = { "com.*" })
@EnableJpaRepositories(basePackages = { "com.apptestAngularJava.ApptestBackEnd.repository" })
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
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
