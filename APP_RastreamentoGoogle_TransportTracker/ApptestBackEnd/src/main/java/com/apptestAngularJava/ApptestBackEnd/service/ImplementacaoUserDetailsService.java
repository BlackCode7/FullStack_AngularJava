package com.apptestAngularJava.ApptestBackEnd.service;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apptestAngularJava.ApptestBackEnd.model.Usuario;
import com.apptestAngularJava.ApptestBackEnd.repository.UsuarioRepository;

@Service
public class ImplementacaoUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		// consulta usuario no banco
		Usuario usuario = usuarioRepository.findUserByLogin(username);
		
		if( usuario == null ) {
			throw new UsernameNotFoundException("usuario não encontrado!");
		}
		
		//return (UserDetails) new User(usuario.getLogin(), usuario.getPassword(), usuario.getAuthorities());
		return (UserDetails) new User( usuario.getLogin(), usuario.getSenha(), usuario.getAuthorities() );
	} // implementa classe padr'ao spring userdatails

}





