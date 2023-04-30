package com.deustotickets.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArtistaTest {

	private Artista artista;
	private TipoUsuario art;
	private TipoGenero ROCK;
	
	
	@Before
	public void create() {
		artista = new Artista("test","test","test",art,ROCK,true);
	}
	
	@Test
	public void getGenero() {
		assertEquals(ROCK, artista.getGenero());
	}
	
	@Test
	public void isVerificada() {
		assertEquals(true, artista.isVerificada());
	}
	
	@Test
	public void setVerificada() {
		artista.setVerificada(false);
		assertEquals(false, artista.isVerificada());
	}
	
	@Test
	public void Artista() {
		Artista arti = new Artista();
	}
	

}
