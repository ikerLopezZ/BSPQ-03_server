package com.deustotickets.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.deustotickets.dao.ArtistaDAO;
import com.deustotickets.dao.ConciertoDAO;
import com.deustotickets.dao.EntradaDAO;
import com.deustotickets.dao.UsuarioDAO;
import com.deustotickets.domain.*;


public class ResourceTest {
	
	Usuario u;
	
	private Usuario usuario;

    private UsuarioDAO usuarioDAO;
    
    private ConciertoDAO conciertoDAO;
    
    private EntradaDAO entradaDAO;
    
    private ArtistaDAO artistaDAO;
    
    private Resource resource;
    
    private Response response;
    
    @Before
    public void setUp() {
      usuario = mock(Usuario.class);
      usuarioDAO = mock(UsuarioDAO.class);
      conciertoDAO = mock(ConciertoDAO.class);
      entradaDAO = mock(EntradaDAO.class);
      artistaDAO = mock(ArtistaDAO.class);
      resource = mock(Resource.class);
      response = mock(Response.class);
      u = new Usuario("test", "test@example.com", "password", TipoUsuario.CLIENTE);
      
      usuario.setNombreApellidos(u.getNombreApellidos());
      usuario.setEmail(u.getEmail());
      usuario.setPassword(u.getPassword());
      usuario.setTipo(u.getTipo());
      }

    @Test
    public void testLoginUserSuccessful() throws Exception {
    	
    	when(usuarioDAO.find(u.getEmail())).thenReturn(u);
    	
    	assertEquals(Resource.loginUser(u).getStatus(), Response.Status.OK.getStatusCode());
    }

    @Test
    public void testLoginUserFailed() throws Exception {
//        Usuario user = new Usuario("Test","test@test.com", "password", TipoUsuario.CLIENTE);
//        Usuario u = new Usuario("Test","test@test.com", "wrongpassword", TipoUsuario.CLIENTE);
//
//        when(usuarioDAO.find(user.getEmail())).thenReturn(u);
//
//        Response response = resource.loginUser(user);
//
//        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    @Test
    public void testLoginUserException() throws Exception {
//        Usuario user = new Usuario("Test","test@test.com", "password", TipoUsuario.CLIENTE);
//
//        when(usuarioDAO.find(user.getEmail())).thenThrow(new RuntimeException());
//
//        Response response = resource.loginUser(user);
//
//        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }
    
    @Test
    public void testgetConcerts() throws Exception {
    	ArrayList<Concierto> lista = new ArrayList<Concierto>();
    	lista.add(new Concierto("Test", null, "Test","Test" , 110));
    	
    	when(conciertoDAO.getAll()).thenReturn(lista);
    
    	assertEquals(Resource.getConcerts().getStatus(), Response.Status.OK.getStatusCode());
    }
    
//    @Test
//    public void testgetConcertsException() throws Exception {
//    	when(conciertoDAO.getAll()).thenThrow(new Exception("TEST"));
//        
//    	assertThrows(Exception.class,() -> Resource.getConcerts());
//    }
    
    @Test
    public void testChangeUsername() throws Exception {
    	when(usuarioDAO.find(u.getEmail())).thenReturn(u);
    	
    	assertEquals(Resource.changeUsername(u).getStatus(), Response.Status.OK.getStatusCode());
    }
    
    
    
}