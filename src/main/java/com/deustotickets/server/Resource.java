package com.deustotickets.server;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.client.Invocation;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.spi.InvocationBuilderListener.InvocationBuilderContext;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import com.deustotickets.db.ArtistaDAO;
import com.deustotickets.db.UsuarioDAO;
import com.deustotickets.domain.Artista;
import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;

import org.apache.logging.log4j.LogManager;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {

	protected static final Logger logger = LogManager.getLogger();

	private PersistenceManager pm = null;
	private Transaction tx = null;

	public Resource() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction();
	}

	@POST
	@Path("/register")
	public Response registerUser(Usuario user) {
		try {
			tx.begin();
			try {
				pm.makePersistent(user);
				logger.info("El usuario ha sido registrado");
			} catch (Exception e) {
				logger.info("Error al registrar");
			}
			tx.commit();
			return Response.ok().build();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
	}

	@POST
	@Path("/login")
	public Response loginUser(Usuario user) {
		try {
			Usuario u = UsuarioDAO.getInstance().find(user.getEmail());
			return Response.ok(u, MediaType.APPLICATION_JSON).build();
		} catch (Exception e){
			return Response.serverError().build();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
	}

//	@GET
//	@Path("/hello")
//	@Produces(MediaType.TEXT_PLAIN)
//	public Response sayHello() {
//		return Response.ok("Hello world!").build();
//	}
}
