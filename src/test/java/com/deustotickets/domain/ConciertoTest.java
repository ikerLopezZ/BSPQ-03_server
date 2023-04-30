package com.deustotickets.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConciertoTest {

	private Concierto concert;
	private Concierto concert2;
	private Artista art;
	private Artista art1;
	
	@Before
	public void inicio() {
		concert = new Concierto("id",art,"fecha","lugar",5);
		concert2 = new Concierto();
	}
	
	@Test
	public void getArtista() {
		assertEquals(art, concert.getArtista());
	}

	@Test
	public void setArtista() {
		concert.setArtista(art1);
		assertEquals(art1, concert.getArtista());
	}
	@Test
	public void getFecha() {
		assertEquals("fecha", concert.getFecha());
	}
	
	@Test
	public void setFecha() {
		concert.setFecha("fecha2");
		assertEquals("fecha2", concert.getFecha());
	}	
	
	@Test
	public void getLugar() {
		assertEquals("lugar", concert.getLugar());
	}
	
	@Test
	public void setLugar() {
		concert.setLugar("lugar2");
		assertEquals("lugar2", concert.getLugar());
	}
	
	@Test
	public void getAforo() {
		assertEquals(5, concert.getAforo());
	}
	
	@Test
	public void setAforo() {
		concert.setAforo(7);
		assertEquals(7, concert.getAforo());
	}
	
	@Test
	public void getId() {
		assertEquals("id", concert.getId());
	}
	
	@Test
	public void setId() {
		concert.setId("id2");
		assertEquals("id2", concert.getId());
	}
	
	
}
