package com.everisdarmytasksms.Ejercicio1.controller;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Storage")

public class Tareas implements Serializable{

	
//	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="estado")
	private String estado;
	
	@Column (name="descripcion")
	private String descripcion;

	
	//añadimos las variasbles estaticas que no se van a cambiar
	
	public static final String ENPROCESO ="En Proceso";
	public static final String ESTADO ="Estado";
	public static final String PENDIENTE ="Pendiente";
	
	
	public Tareas() {}
	
	public Tareas(String descripcion, String estado)
	
	{
		super();
		this.estado=estado;
		this.descripcion=descripcion;
	}

	
	//Realizamos los Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		Tareas other = (Tareas) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}
	
	
}
