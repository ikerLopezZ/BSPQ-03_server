package com.deustotickets.domain;

import java.io.Serializable;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Artista extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	public TipoGenero genero;
	public boolean verificada;
	
	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public Artista(String nombreApellidos, String email, String contrasenya, TipoUsuario tipo,
			TipoGenero genero, boolean verificada) {
		super(nombreApellidos, email, contrasenya, tipo);
		this.genero = genero;
		this.verificada = verificada;
	}
	
	public boolean isVerificada() {
		return verificada;
	}

	public void setVerificada(boolean verificada) {
		this.verificada = verificada;
	}

	public Artista() {
		super();
	}
	
	public Artista(Usuario u, TipoGenero tg, boolean setVerification, boolean verified) {
		super(u.getNombreApellidos(), u.getEmail(), u.getPassword(), u.getTipo());
		
		if(tg != null) {
			this.genero = tg;
		} else if(setVerification) {
			this.verificada = verified;
		} else {
			this.verificada = false;
		}
		
	}

}