package com.apptestAngularJava.ApptestBackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apptestAngularJava.ApptestBackEnd.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query( value = " Select u from Usuario u where upper(trim(u.nome)) like %?1% " )
	List<Usuario> buscaPorNome(String nome);

	//Usuario saveAll(Long idUser);
	
}