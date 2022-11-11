package com.apptestAngularJava.ApptestBackEnd.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.sun.net.httpserver.Filter.Chain;

// Filtro todas requisições serao capturadas para autenticar
public class JWTApiAutenticacaoFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// Estabelece  autenticaçao para requisicao
		Authentication authentication = new JWTTokenAuthenticacaoService().getAuthentication((HttpServletRequest) request);
		
		// 
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		chain.doFilter(request, response);
		
	}

}
