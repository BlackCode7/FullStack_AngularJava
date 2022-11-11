package com.apptestAngularJava.ApptestBackEnd.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.apptestAngularJava.ApptestBackEnd.model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

// Estabelece o gerenciador de token
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	// Config o gerenciador de autenticação
	protected JWTLoginFilter( String url, AuthenticationManager authenticationManager) {
		
		//Obriga a autenticar URL
		super( new AntPathRequestMatcher(url));
		
		//Gerencia a autenticação
		setAuthenticationManager(authenticationManager);
		
	}

	@Override // retorna o usuario que esta sendo processado
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		// Pega o token para validar
		Usuario user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
		
		// Retorna  o usuario login senha e acesso
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getSenha()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		new JWTTokenAuthenticacaoService().addAuthentication(response, authResult.getName());		
	}

}














