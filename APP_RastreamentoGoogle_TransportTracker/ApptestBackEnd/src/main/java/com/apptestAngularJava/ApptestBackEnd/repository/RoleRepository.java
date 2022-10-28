package com.apptestAngularJava.ApptestBackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apptestAngularJava.ApptestBackEnd.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query( value = " Select r from Role r where upper(trim(r.papelRole)) like %?1% " )
	List<Role> buscaPorPapel(String papelRole);
}
