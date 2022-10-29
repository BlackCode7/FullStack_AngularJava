package com.apptestAngularJava.ApptestBackEnd.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator( name = "seq_serie", allocationSize = 1, initialValue = 1 )
public class SeriePeito implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_serie")
	private Long id_serie;
	private String nomeExercicio;
	private int numeroSerie;
	private int numeroRepeticao;
	private int cargaPeso;
	
	@JsonIgnore
	@ForeignKey( name = "usuario_id" )
	@ManyToOne( optional = false )
	private Usuario usuario;

	public SeriePeito() {}

	@Override
	public String toString() {
		return "SeriePeito [id_serie=" + id_serie + ", nomeExercicio=" + nomeExercicio + ", numeroSerie=" + numeroSerie
				+ ", numeroRepeticao=" + numeroRepeticao + ", cargaPeso=" + cargaPeso + ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cargaPeso;
		result = prime * result + ((id_serie == null) ? 0 : id_serie.hashCode());
		result = prime * result + ((nomeExercicio == null) ? 0 : nomeExercicio.hashCode());
		result = prime * result + numeroRepeticao;
		result = prime * result + numeroSerie;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		SeriePeito other = (SeriePeito) obj;
		if (cargaPeso != other.cargaPeso)
			return false;
		if (id_serie == null) {
			if (other.id_serie != null)
				return false;
		} else if (!id_serie.equals(other.id_serie))
			return false;
		if (nomeExercicio == null) {
			if (other.nomeExercicio != null)
				return false;
		} else if (!nomeExercicio.equals(other.nomeExercicio))
			return false;
		if (numeroRepeticao != other.numeroRepeticao)
			return false;
		if (numeroSerie != other.numeroSerie)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public Long getId_serie() {
		return id_serie;
	}

	public void setId_serie(Long id_serie) {
		this.id_serie = id_serie;
	}

	public String getNomeExercicio() {
		return nomeExercicio;
	}

	public void setNomeExercicio(String nomeExercicio) {
		this.nomeExercicio = nomeExercicio;
	}

	public int getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public int getNumeroRepeticao() {
		return numeroRepeticao;
	}

	public void setNumeroRepeticao(int numeroRepeticao) {
		this.numeroRepeticao = numeroRepeticao;
	}

	public int getCargaPeso() {
		return cargaPeso;
	}

	public void setCargaPeso(int cargaPeso) {
		this.cargaPeso = cargaPeso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
