package com.deustotickets.domain;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable="true")
public class Concierto {
	//Atributos:
	private int id;
	private Artista artista;
	private String fecha;
	private String lugar;
	private String aforo;
	
	//Constructor
	public Concierto(Artista artista, String fecha, String lugar, String aforo) {
		super();
		this.artista = artista;
		this.fecha = fecha;
		this.lugar = lugar;
		this.aforo = aforo;
	}

	//Getters y setters
	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getAforo() {
		return aforo;
	}

	public void setAforo(String aforo) {
		this.aforo = aforo;
	}

	//toString
	@Override
	public String toString() {
		return "Concierto [artista=" + artista.toString() + ", fecha=" + fecha + ", lugar=" + lugar + ", aforo=" + aforo + "]";
	}
}