package com.deustotickets.domain;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Artista extends Usuario{

	public TipoGenero genero;
	
	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public Artista(String nombreApellidos, String email, String contrasenya, TipoUsuario tipo,
			TipoGenero genero) {
		super(nombreApellidos, email, contrasenya, tipo);
		this.genero = genero;
	}
	
	public Artista() {
	}


}
