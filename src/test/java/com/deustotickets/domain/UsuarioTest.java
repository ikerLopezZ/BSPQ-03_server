package com.deustotickets.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	Usuario user;
	TipoUsuario usuario;
	
	@Before
	public void create() {
		user = new Usuario("nombre","email","pass",usuario);
	}
	
	@Test
	public void getNombre() {
		assertEquals("nombre", user.getNombreApellidos());
	}
	
	@Test
	public void setNombre() {
		user.setNombreApellidos("nombre2");
		assertEquals("nombre2", user.getNombreApellidos());
	}
	
	@Test
	public void getEmail() {
		assertEquals("email", user.getEmail());
	}
	
	@Test
	public void setEmail() {
		user.setEmail("email2");
		assertEquals("email2", user.getEmail());
	}
	
	@Test
	public void getPassword() {
		assertEquals("pass", user.getPassword());
	}
	
	@Test
	public void setPassword() {
		user.setPassword("1234");
		assertEquals("1234", user.getPassword());
	}
	

	@Test
	public void isBanned() {
		assertEquals(false, user.isBanned());
	}
	
	@Test
	public void setBanned() {
		user.setBanned(true);
		assertEquals(true, user.isBanned());
	}
}
