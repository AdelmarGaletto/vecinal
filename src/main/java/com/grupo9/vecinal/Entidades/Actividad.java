package com.grupo9.vecinal.Entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "actividades")
public class Actividad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idActividades;

	private String nombreActividad;
	private String descripcionActividad;
	//ESTO NO SIRVE.
	//@Temporal(TemporalType.DATE)
	//@DateTimeFormat(style = "S-")
	private LocalDate fecha;
	
	private Boolean alta;
	private Integer cupo;

	@ManyToMany(mappedBy = "actividades")
	private Set<Usuario> usuarios;

	public Actividad() {
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Integer getIdActividades() {
		return idActividades;
	}

	public void setIdActividades(Integer idActividades) {
		this.idActividades = idActividades;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}


	@Override
	public String toString() {
		return "Actividad [idActividades=" + idActividades + ", nombreActividad=" + nombreActividad
				+ ", descripcionActividad=" + descripcionActividad + ", fecha=" + fecha + ", alta=" + alta + ", cupo="
				+ cupo+"]";
	}

}
