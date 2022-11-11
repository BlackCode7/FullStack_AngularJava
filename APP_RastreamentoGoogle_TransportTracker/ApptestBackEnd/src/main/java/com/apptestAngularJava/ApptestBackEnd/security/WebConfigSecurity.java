package com.apptestAngularJava.ApptestBackEnd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.apptestAngularJava.ApptestBackEnd.service.ImplementacaoUserDetailsService;

// mapeamos endereços, url autoriza ou bloqueia os acessos
@Configuration
@EnableWebSecurity //1
public class WebConfigSecurity extends WebSecurityConfigurerAdapter{ //2
	
	//3
	@Autowired
	private ImplementacaoUserDetailsService implementacaoUserDetailsService;	

	// 4 - configura as solicitação de acesso por http
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Ativando a proteção contra usuario não validados por token
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		
		// Ativasndo o acesso a página inicial para usuarios nã válidos
		.disable().authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/index").permitAll() //;
		
		// URL de logout - Redireciona apos o user deslogar do sistema
		.anyRequest().authenticated().and().logout().logoutUrl("/index") // >>>> falta o arquivo estar disponivel
		
		// Mapeia URl de Logout 
		.logoutRequestMatcher( new AntPathRequestMatcher( "/logout" )) // >>>> falta o arquivo estar disponivel
				
		// Criação do JWT - filtra as requisições de login para autenticação 
		.and().addFilterBefore( new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
		
		// Filtra demais requisições para verificar a presença do TOKEN JWT no header http 
		.addFilterBefore(new JWTApiAutenticacaoFilter(), UsernamePasswordAuthenticationFilter.class);
		
		
		
	}
	
	// 5
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Service que irá consultar o usuario no banco de dados
		auth.userDetailsService(implementacaoUserDetailsService)
		
		// Padrão de condificação de senha de usuario
		.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	

}
