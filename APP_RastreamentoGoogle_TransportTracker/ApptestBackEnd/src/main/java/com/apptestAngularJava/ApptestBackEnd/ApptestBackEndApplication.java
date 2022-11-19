package com.apptestAngularJava.ApptestBackEnd;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
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
public class ApptestBackEndApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(ApptestBackEndApplication.class, args);
		
		//System.out.println( new BCryptPasswordEncoder().encode("Carro!@#123_(*&."));
		// $2a$10$nCxj1SwiZEp3fWhktxL95uhf/lDyA1teNDU07j6R3WhajsALklzwu    -  anderson = 123
		// $2a$10$hnQ5dIhTXJKQNmcoT0zirOrdh2aOqTPYEFUMQxS3F2E.RW1Abm9nK   - simone = Carro!@#123
		// $2a$10$fT.U4iWVGfFY1Qs3cuth4uVhm.plKRZ8DmKwe00.hl1kJI2yI.OE. -- carlos = Carro!@#123_(*&.
		// $2a$10$eJ/MTrKDY5PqWur9GZOFYer.hNIq0qSAW5IpLOLqEJzJ1PopIn9qu
		
	}
	
	/*@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.headers().frameOptions().disable();
		http.cors().and().csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeHttpRequests((auth) -> auth.anyRequest().permitAll());

		return http.build();
	}*/

	/*
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}*/
	
	/*
	//Liberando o cors da aplicação
	@Override
	public void addCorsMappings( CorsRegistry registry ) {
		registry.addMapping("/usuario/**")
		.allowedMethods("*")
		.allowedOrigins("*");//http://localhost:4200/
	} */
		
	
	
	

}
