package com.deustotickets.domain;

import java.io.Serializable;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable = "true")
public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	private String id;
	@Persistent(defaultFetchGroup = "true")
	private Concierto concierto;
	private double precio;
	private String nombre;
	// Pensar si queremos hacer tipos de entrada (VIP, normal...)

	public Entrada(String id, Concierto concierto, double precio, String nombre) {
		super();
		this.id = id;
		this.concierto = concierto;
		if(this.concierto.getEntradasDisponibles() > 0) {
			this.concierto.comprarEntrada();
		}
		this.precio = precio;
		this.nombre = nombre;
	}
	
	public Entrada() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Concierto getConcierto() {
		return concierto;
	}

	public void setConcierto(Concierto concierto) {
		this.concierto = concierto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", concierto=" + concierto + ", precio=" + precio + ", nombre=" + nombre + "]";
	}
	
}