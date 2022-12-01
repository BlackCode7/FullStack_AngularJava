package com.AppArranjoDeOnibus.AppArranjoDeOnibusBackend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Com lombok instalado
// https://www.youtube.com/watch?v=W0ywxkvc4_M

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ArranjoDeOnibusModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Integer id;
	private String nomePublicador;
	private Date data;
	private Integer valorPago;
	
	@Override
	public String toString() {
		return "ArranjoDeOnibusModel [id=" + id + ", nomePublicador=" + nomePublicador + ", data=" + data
				+ ", valorPago=" + valorPago + "]";
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArranjoDeOnibusModel other = (ArranjoDeOnibusModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
