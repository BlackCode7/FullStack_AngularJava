package com.apptestAngularJava.ApptestBackEnd.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue( strategy = GenerationType.SEQUENCE)
	public Long idRole;
	public String papelRole;
	public Role() {}
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
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", papelRole=" + papelRole + "]";
	}

}
