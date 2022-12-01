package com.AppArranjoDeOnibus.AppArranjoDeOnibusBackend.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.AppArranjoDeOnibus.AppArranjoDeOnibusBackend.model.ArranjoDeOnibusModel;

@Repository
public interface ArranjoDeOnibusBackEndRepository extends JpaRepository<ArranjoDeOnibusModel, Integer>{
	
	// Busca por data de pagamento
	@Query( " Select d from ArranjoDeOnibusModel d where d.data = ?1 " )
	List<ArranjoDeOnibusModel> findByData( Date data );
	
	// Busca por id
	@Query( " Select i from ArranjoDeOnibusModel i where i.id = ?1 " )
	Optional<ArranjoDeOnibusModel> findById( Integer id );
	
	// Busca por nome do publicador
	@Query( value = " Select n from ArranjoDeOnibusModel n where n.nomePublicador = ?1 " )
	ArranjoDeOnibusModel findArranjoDeOnibusModel( String nomePublicador );
	
	// Busca por todos os publicadores
	@Query( value = " Select t from ArranjoDeOnibusModel t where upper(trim(t.nomePublicador)) like %?1% " )
	List<ArranjoDeOnibusModel> findPorTodosPublicadores( String nomePublicador );
	
}
