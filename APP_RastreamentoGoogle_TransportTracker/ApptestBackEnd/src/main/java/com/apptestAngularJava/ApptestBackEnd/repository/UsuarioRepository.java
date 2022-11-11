package com.apptestAngularJava.ApptestBackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apptestAngularJava.ApptestBackEnd.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query( "Select u from Usuario u where u.login = ?1" )
	Usuario findUserByLogin(String login);//3
	
	@Query( value = " Select u from Usuario u where upper(trim(u.login)) like %?1% " )
	List<Usuario> buscaPorLogin(String login);//2
	
	//Usuario saveAll(Long idUser);//1
	
}
