package com.deustotickets.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.deustotickets.dao.ArtistaDAO;
import com.deustotickets.dao.ConciertoDAO;
import com.deustotickets.dao.EntradaDAO;
import com.deustotickets.dao.UsuarioDAO;
import com.deustotickets.domain.Artista;
import com.deustotickets.domain.Concierto;
import com.deustotickets.domain.Entrada;
import com.deustotickets.domain.TipoGenero;
import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;

/**
 * 
 * @author BSPQ-03
 *
 */
public class AppTest {
	@Mock
	private UsuarioDAO userdao;
	
	@Mock
	private ArtistaDAO artistdao;
	
	@Mock
	private ConciertoDAO concertdao;
	
	private List<Usuario> users = new ArrayList<Usuario>();
	private List<Artista> artists = new ArrayList<Artista>();
	
	Artista a1 = new Artista("Ana Alonso", "ana@gmail.com", "123", TipoUsuario.ARTISTA, TipoGenero.GOSPEL, false);
	Artista a2 = new Artista("Marco Marquez", "marco@gmail.com", "456", TipoUsuario.ARTISTA, TipoGenero.REGGAETON, true);
	Artista a3 = new Artista("Jon Bilbao", "jon@gmail.com", "789", TipoUsuario.ARTISTA, TipoGenero.COUNTRY, true);
	
	Concierto c1 = new Concierto("BEC1", a1, "12/12/2023", "BEC - Bilbao", 10500);
	Concierto c2 = new Concierto("BEC2", a2, "24/06/2023", "Wizink Center - Madrid", 50000);
	Concierto c3 = new Concierto("BEC3", a3, "01/02/2024", "Kafe Antzokia - Bilbao", 100);

	Entrada e1 = new Entrada("0", c1, 50.35, "Normal");
	Entrada e2 = new Entrada("1", c2, 137.23, "VIP");
	Entrada e3 = new Entrada("2", c3, 40.99, "Noche");
	
	Usuario u1 = new Usuario("Pablo Martinez", "pablo@gmail.com", "pablo123", TipoUsuario.CLIENTE);
	Usuario u2 = new Usuario("Maria Pascual", "maria@gmail.com", "maria123", TipoUsuario.CLIENTE);
	Usuario u3 = new Usuario("Itzi Ramos", "itzi@gmail.com", "itzi123", TipoUsuario.CLIENTE);
	
	Usuario gestor1 = new Usuario("Peio Gonzalez", "peio@gmail.com", "gestor123", TipoUsuario.GESTOR);
	Usuario gestor2 = new Usuario("Amaia Sanz", "amaia@gmail.com", "gestor123", TipoUsuario.GESTOR);
	Usuario gestor3 = new Usuario("Elisa Alonso", "elisa@gmail.com", "gestor123", TipoUsuario.GESTOR);
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		userdao = new UsuarioDAO();
		artistdao = new ArtistaDAO();
		concertdao = new ConciertoDAO();
		
		users.add(a1);
		users.add(a2);
		users.add(a3);
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(gestor1);
		users.add(gestor2);
		users.add(gestor3);
		
		artists.add(a1);
		artists.add(a2);
		artists.add(a3);
				
	}

	@After
	public void tearDown() throws Exception {
		userdao = null;
		artistdao = null;
		concertdao = null;
	}
	

	// ArtistaDAO
	@Test
	public void getAllArtistaTest() {
		when(artistdao.getInstance().getAll()).thenReturn(artists);
		ArrayList<Artista> todos = (ArrayList<Artista>) artistdao.getInstance().getAll();
		assertEquals(3, todos.size());
	}
	
	@Test
	public void findArtistaTest() {

	}
	
	// ConciertoDAO
	@Test
	public void getAllConciertoTest() {

	}
	
	@Test
	public void findConciertoTest() {

	}
	
	// EntradaDAO
	@Test
	public void getAllEntradaTest() {

	}
	
	@Test
	public void findEntradaTest() {

	}
	
	// UsuarioDAO
	@Test
	public void getAllUsuarioTest() {

	}
	
	@Test
	public void findUsuarioTest() {

	}
}
