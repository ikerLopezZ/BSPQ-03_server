package com.deustotickets.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EntradaTest {

	private Entrada entrada;
	private Concierto concierto;
	
	@Before
	public void start() {
		entrada = new Entrada("id",concierto,15,"nombre");
		
	}
	@Test
	public void getId() {
		assertEquals("id", entrada.getId());
	}
	
	@Test
	public void setId() {
		entrada.setId("id2");
		assertEquals("id2", entrada.getId());
	}
	
	@Test
	public void getConcierto() {
		assertEquals(concierto, entrada.getConcierto());
	}
	
	@Test
	public void setconcierto() {
		Concierto concierto2 = new Concierto();
		entrada.setConcierto(concierto2);
		assertEquals(concierto2, entrada.getConcierto());
	}

	@Test
	public void getPrecio() {
		double valor = 15;
		assertEquals(valor, entrada.getPrecio());
	}
	
	@Test
	public void setPrecio() {
		entrada.setPrecio(1);
		double valor = 1;
		assertEquals(valor, entrada.getPrecio());
	}
	
	@Test
	public void getNombre() {
		assertEquals("nombre", entrada.getNombre());
	}
	@Test
	public void setNombre() {
		entrada.setNombre("nombre2");
		assertEquals("nombre2", entrada.getNombre());
	}
}
