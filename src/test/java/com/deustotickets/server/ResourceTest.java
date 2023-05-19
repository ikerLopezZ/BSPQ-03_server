package com.deustotickets.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.mockitoSession;
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
import org.mockito.Mockito;
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
	
	@Mock
	private Usuario usuario;
	@Mock
    private UsuarioDAO usuarioDAO;
	@Mock
    private ConciertoDAO conciertoDAO;
	@Mock
    private EntradaDAO entradaDAO;
	@Mock
    private ArtistaDAO artistaDAO;
	
    private Resource resource;
	@Mock
    private Response response;
    
    @Before
    public void setUp() {
    	usuario = mock(Usuario.class);
    	usuarioDAO = mock(UsuarioDAO.class);
    	conciertoDAO = mock(ConciertoDAO.class);
    	entradaDAO = mock(EntradaDAO.class);
    	artistaDAO = mock(ArtistaDAO.class);
    	response = mock(Response.class);
    	
    	resource = new Resource();
    	
      u = new Usuario("test", "test@example.com", "password", TipoUsuario.CLIENTE);
      
      usuario.setNombreApellidos(u.getNombreApellidos());
      usuario.setEmail(u.getEmail());
      usuario.setPassword(u.getPassword());
      usuario.setTipo(u.getTipo());
      }

    @Test
    public void testLoginUserFailure() throws Exception {
    	when(usuarioDAO.find(u.getEmail())).thenReturn(u);
    	
    	Usuario uaux = u;
    	uaux.setPassword(u.getPassword() + ".");
    	assertEquals(resource.loginUser(uaux).getStatus(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }


    @Test
    public void testGetConcertsFailure() {
    	
    }
    
    @Test
    public void testRegisterUserFailure() {
    	
    }
    
    @Test
    public void testChangeUsernameFailure() throws Exception {
    	when(usuarioDAO.find(Mockito.anyString())).thenReturn(u);
    	
    	assertEquals(resource.changeUsername(u).getStatus(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }
    
    
    
}