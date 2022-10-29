package com.apptestAngularJava.ApptestBackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apptestAngularJava.ApptestBackEnd.model.SeriePeito;

@Repository
public interface SeriePeitoRepository extends JpaRepository<SeriePeito, Long>{
	
	@Query( value = " Select sp from SeriePeito sp where upper(trim(sp.nomeExercicio)) like %?1% " )
	List<SeriePeito> buscaPorNomeExercicio( String nomeExercicio);

}
