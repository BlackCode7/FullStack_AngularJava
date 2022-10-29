package com.apptestAngularJava.ApptestBackEnd.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue( strategy = GenerationType.SEQUENCE)
	public Long idRole;
	public String papelRole;
	
	//@JsonIgnore
	//@ForeignKey(name = "usuario_id")
	//@ManyToOne(optional = false)
	//public Usuario usuario;

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getPapelRole() {
		return papelRole;
	}

	public void setPapelRole(String papelRole) {
		this.papelRole = papelRole;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
