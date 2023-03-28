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
	
	Concierto c1 = new Concierto(a1, "12/12/2023", "BEC - Bilbao", 10500);
	Concierto c2 = new Concierto(a2, "24/06/2023", "Wizink Center - Madrid", 50000);
	Concierto c3 = new Concierto(a3, "01/02/2024", "Kafe Antzokia - Bilbao", 100);

	Entrada e1 = new Entrada(0, a1, 50.35, "Normal");
	Entrada e2 = new Entrada(1, a2, 137.23, "VIP");
	Entrada e3 = new Entrada(2, a3, 40.99, "Noche");
	
	Usuario u1 = new Usuario("Pablo", "Martinez", "pablo@gmail.com", "pablo123", TipoUsuario.CLIENTE);
	Usuario u2 = new Usuario("Maria", "Pascual", "maria@gmail.com", "maria123", TipoUsuario.CLIENTE);
	Usuario u3 = new Usuario("Itzi", "Ramos", "itzi@gmail.com", "itzi123", TipoUsuario.CLIENTE);
	
	Usuario gestor1 = new Usuario("Peio", "Gonzalez", "peio@gmail.com", "gestor123", TipoUsuario.GESTOR);
	Usuario gestor2 = new Usuario("Amaia", "Sanz", "amaia@gmail.com", "gestor123", TipoUsuario.GESTOR);
	Usuario gestor3 = new Usuario("Elisa", "Alonso", "elisa@gmail.com", "gestor123", TipoUsuario.GESTOR);
	
	@Before
	public void setUp() throws Exception {
		//Guardamos los CONCIERTOS en la BD:
		ConciertoDAO.getInstance().save(c1);
		ConciertoDAO.getInstance().save(c2);
		ConciertoDAO.getInstance().save(c3);
		
		//Guardamos las ENTRADAS en la BD:
		EntradaDAO.getInstance().save(e1);
		EntradaDAO.getInstance().save(e2);
		EntradaDAO.getInstance().save(e3);
		
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
		//Borramos los CONCIERTOS de la BD:
		ConciertoDAO.getInstance().delete(c1);
		ConciertoDAO.getInstance().delete(c2);
		ConciertoDAO.getInstance().delete(c3);

		//Borramos las ENTRADAS de la BD:
		EntradaDAO.getInstance().delete(e1);
		EntradaDAO.getInstance().delete(e2);
		EntradaDAO.getInstance().delete(e3);
		
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
		int resultado = 0;
		String nombreArtista = a1.getNombreApellidos();
		Artista artista = ArtistaDAO.getInstance().find(nombreArtista);
		if(nombreArtista.equals(artista.getNombreApellidos())) {
			resultado = 1;
		}
		assertEquals(1, resultado);
	}
	
	// ConciertoDAO
	@Test
	public void getAllConciertoTest() {
		List<Concierto> todosConciertos = ConciertoDAO.getInstance().getAll();
		boolean comp = (todosConciertos.size()==3);
		assertEquals(true, comp);
	}
	
//	@Test
//	public void findConciertoTest() {
//		int resultado = 0;
//		int idConcierto = c1.get;	//get id?
//		Concierto concierto = ConciertoDAO.getInstance().find(idConcierto);
//		if(idConcierto.equals(concierto.get())) {	//get id?
//			resultado = 1;
//		}
//		assertEquals(1, resultado); 
//	}
	
	// EntradaDAO
	@Test
	public void getAllEntradaTest() {
		List<Entrada> todasEntradas = EntradaDAO.getInstance().getAll();
		boolean comp = (todasEntradas.size()==3);
		assertEquals(true, comp);
	}
	
	@Test
	public void findEntradaTest() {
		int resultado = 0;
		String nombreEntrada = e1.getNombre();
		Entrada entrada = EntradaDAO.getInstance().find(nombreEntrada);
		if(nombreEntrada.equals(entrada.getNombre())) {
			resultado = 1;
		}
		assertEquals(1, resultado); 
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
		int resultado = 0;
		String nombreUsuario = u1.getNombreApellidos();
		Usuario usuario = UsuarioDAO.getInstance().find(nombreUsuario);
		if(nombreUsuario.equals(usuario.getNombreApellidos())) {
			resultado = 1;
		}
		assertEquals(1, resultado); 
	}
}
