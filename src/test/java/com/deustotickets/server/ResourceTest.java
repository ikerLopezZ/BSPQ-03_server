package com.deustotickets.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
import com.deustotickets.dao.UsuarioDAO;
import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;



public class ResourceTest {

    @Mock
    private UsuarioDAO usuarioDAO;
    @Mock
    private Resource resource;
    
    @Before
    public void setUp() {
      MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginUserSuccessful() throws Exception {
//        Usuario u = new Usuario("Test", "test@example.com", "password", TipoUsuario.CLIENTE);
//
//        when(usuarioDAO.find(eq(u.getEmail()))).thenReturn(u);
//
//        Response response = resource.loginUser(u);
//
//        assertEquals(200, response.getStatus());
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
}