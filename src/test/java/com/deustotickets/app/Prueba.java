package com.deustotickets.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.deustotickets.db.ArtistaDAO;
import com.deustotickets.db.ConciertoDAO;
import com.deustotickets.db.EntradaDAO;
import com.deustotickets.db.UsuarioDAO;
import com.deustotickets.domain.Artista;
import com.deustotickets.domain.Concierto;
import com.deustotickets.domain.Entrada;
import com.deustotickets.domain.TipoGenero;
import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;

public class Prueba {

	Artista a1 = new Artista("Ana", "Alonso", "ana@gmail.com", "123", TipoUsuario.ARTISTA, TipoGenero.GOSPEL);
	Artista a2 = new Artista("Marco", "Marquez", "marco@gmail.com", "456", TipoUsuario.ARTISTA, TipoGenero.REGGAETON);
	Artista a3 = new Artista("Jon", "Bilbao", "jon@gmail.com", "789", TipoUsuario.ARTISTA, TipoGenero.COUNTRY);
	
	Concierto c1 = new Concierto("BEC1", a1, "12/12/2023", "BEC - Bilbao", 10500);
	Concierto c2 = new Concierto("BEC2", a2, "24/06/2023", "Wizink Center - Madrid", 50000);
	Concierto c3 = new Concierto("BEC3", a3, "01/02/2024", "Kafe Antzokia - Bilbao", 100);

	Entrada e1 = new Entrada("0", c1, 50.35, "Normal");
	Entrada e2 = new Entrada("1", c2, 137.23, "VIP");
	Entrada e3 = new Entrada("2", c3, 40.99, "Noche");
	
	Usuario u1 = new Usuario("Pablo", "Martinez", "pablo@gmail.com", "pablo123", TipoUsuario.CLIENTE);
	Usuario u2 = new Usuario("Maria", "Pascual", "maria@gmail.com", "maria123", TipoUsuario.CLIENTE);
	Usuario u3 = new Usuario("Itzi", "Ramos", "itzi@gmail.com", "itzi123", TipoUsuario.CLIENTE);
	
	Usuario gestor1 = new Usuario("Peio", "Gonzalez", "peio@gmail.com", "gestor123", TipoUsuario.GESTOR);
	Usuario gestor2 = new Usuario("Amaia", "Sanz", "amaia@gmail.com", "gestor123", TipoUsuario.GESTOR);
	Usuario gestor3 = new Usuario("Elisa", "Alonso", "elisa@gmail.com", "gestor123", TipoUsuario.GESTOR);
	
	@Before
	public void setUp() throws Exception {
		//Guardamos las ENTRADAS en la BD:
		EntradaDAO.getInstance().save(e1);
		EntradaDAO.getInstance().save(e2);
		EntradaDAO.getInstance().save(e3);
		
		//Guardamos los CONCIERTOS en la BD:
		ConciertoDAO.getInstance().save(c1);
		ConciertoDAO.getInstance().save(c2);
		ConciertoDAO.getInstance().save(c3);
		
		//Guardamos los ARTISTAS en la BD:
		UsuarioDAO.getInstance().save(a1);
		UsuarioDAO.getInstance().save(a2);
		UsuarioDAO.getInstance().save(a3);
		
		//Guardamos los CLIENTES en la BD:
		UsuarioDAO.getInstance().save(u1);
		UsuarioDAO.getInstance().save(u2);
		UsuarioDAO.getInstance().save(u3);
		
		//Guardamos los GESTORES en la BD:
		UsuarioDAO.getInstance().save(gestor1);
		UsuarioDAO.getInstance().save(gestor2);
		UsuarioDAO.getInstance().save(gestor3);
				
	}

	@After
	public void tearDown() throws Exception {
		//Borramos las ENTRADAS de la BD:
		EntradaDAO.getInstance().delete(e1);
		EntradaDAO.getInstance().delete(e2);
		EntradaDAO.getInstance().delete(e3);
		
		//Borramos los CONCIERTOS de la BD:
		ConciertoDAO.getInstance().delete(c1);
		ConciertoDAO.getInstance().delete(c2);
		ConciertoDAO.getInstance().delete(c3);
		
		//Borramos los ARTISTAS de la BD:
		ArtistaDAO.getInstance().delete(a1);
		ArtistaDAO.getInstance().delete(a2);
		ArtistaDAO.getInstance().delete(a3);
		
		//Borramos los CLIENTES de la BD:
		UsuarioDAO.getInstance().delete(u1);
		UsuarioDAO.getInstance().delete(u2);
		UsuarioDAO.getInstance().delete(u3);
		
		//Borramos los GESTORES de la BD:
		UsuarioDAO.getInstance().delete(gestor1);
		UsuarioDAO.getInstance().delete(gestor2);
		UsuarioDAO.getInstance().delete(gestor3);
		
	}
	

	// ArtistaDAO
	@Test
	public void getAllArtistaTest() {
		List<Artista> todosArtistas = ArtistaDAO.getInstance().getAll();
		boolean comp = (todosArtistas.size()==3);
		assertEquals(true, comp);
	}
	
	@Test
	public void findArtistaTest() {
		String email = a1.getEmail();
		Artista artista = ArtistaDAO.getInstance().find(email);
		assertEquals(email, artista.getEmail());
	}
	
	// ConciertoDAO
	@Test
	public void getAllConciertoTest() {
		List<Concierto> todosConciertos = ConciertoDAO.getInstance().getAll();
		boolean comp = (todosConciertos.size()==3);
		assertEquals(true, comp);
	}
	
	@Test
	public void findConciertoTest() {
		String idInput = "BEC1";
		Concierto concierto = ConciertoDAO.getInstance().find(idInput);
		assertEquals(idInput, concierto.getId());
	}
	
	// EntradaDAO
	@Test
	public void getAllEntradaTest() {
		List<Entrada> todasEntradas = EntradaDAO.getInstance().getAll();
		boolean comp = (todasEntradas.size()==3);
		assertEquals(true, comp);
	}
	
	@Test
	public void findEntradaTest() {
		String id = e1.getId();
		Entrada entrada = EntradaDAO.getInstance().find(id);
		assertEquals(id, entrada.getId()); 
	}
	
	// UsuarioDAO
	@Test
	public void getAllUsuarioTest() {
		List<Usuario> todosUsuarios = UsuarioDAO.getInstance().getAll();
		boolean comp = (todosUsuarios.size()==9);	//9, porque también entran los artistas en esta clase.
		assertEquals(true, comp);
	}
	
	@Test
	public void findUsuarioTest() {
		String email= u1.getEmail();
		Usuario usuario = UsuarioDAO.getInstance().find(email);
		assertEquals(email, usuario.getEmail()); 
	}
}
