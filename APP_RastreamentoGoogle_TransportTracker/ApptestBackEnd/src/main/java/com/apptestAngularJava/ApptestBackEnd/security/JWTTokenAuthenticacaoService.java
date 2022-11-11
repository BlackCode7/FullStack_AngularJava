package com.apptestAngularJava.ApptestBackEnd.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.apptestAngularJava.ApptestBackEnd.ApplicationContextLoad;
import com.apptestAngularJava.ApptestBackEnd.model.Usuario;
import com.apptestAngularJava.ApptestBackEnd.repository.UsuarioRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Component
public class JWTTokenAuthenticacaoService {

	// tempo de validade do token
	private static final long EXPIRATION_TIME = 17280000;
	
	// uma senha unica para compor a autenticação
	private static final String SECRET = "SenhaExtremamenteSecreta";

	// prefixo padrão de Token
	private static final String TOKEN_PREFIX = "Bearer";
	
	// usado para localizar a autorização
	private static final String HEADER_STRING = "Authorization";

	// gernado token de autenticação a add ao cabeçalho
	public void addAuthentication( HttpServletResponse response, String username ) throws IOException{		
		// motagem do token
		String JWT = Jwts.builder().setSubject(username) // chama o geraor de token
				.setExpiration(new Date( System.currentTimeMillis() + EXPIRATION_TIME )) // tempo de expiração
				.signWith(SignatureAlgorithm.HS512, SECRET).compact(); // compactação algoritm geração de senha
	
		// Juntar com o prefix para formar o token
		String token = TOKEN_PREFIX + " " + JWT; // Bearer >>> forma o token
		
		// Adicioan um cabeçalho http
		response.addHeader(HEADER_STRING, token);// juntado Authorzation: Bearer + nsdflabsfoqebofqbeubq3o
		
		// Escreve token como resposta no corpo do http
		response.getWriter().write("{\"Authorization\": \""+token+"\"}");	
		
	}
	
	// Retorna o usuario validado com token ou caso nao seja valido retorna null
	public Authentication getAuthentication(HttpServletRequest request ) {
		
		//Pega o token enviado no cabeçalho http
		String token = request.getHeader(HEADER_STRING);
		
		if(token != null) {
			// faz a validação do token do usuario            // token completo     //retira o bearer
			String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJwt(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();// pega so o usuario
			if(user != null) {				
				Usuario usuario = ApplicationContextLoad.getApplicationContext().getBean(UsuarioRepository.class).findUserByLogin(user);				
				if( usuario != null ) {
					return new UsernamePasswordAuthenticationToken(usuario.getLogin(), usuario.getSenha(), usuario.getAuthorities());
				}
			}	
		}
		return null;
	}
	
	
	
	
}











