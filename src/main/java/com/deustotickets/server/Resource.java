package com.deustotickets.server;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.Logger;

import com.deustotickets.dao.UsuarioDAO;
import com.deustotickets.domain.Usuario;

import org.apache.logging.log4j.LogManager;

/**
 * 
 * @author BSPQ-03
 *
 */
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
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@POST
	@Path("/login")
	public Response loginUser(Usuario user) {
		try {
			Usuario u = UsuarioDAO.getInstance().find(user.getEmail());
			if(user.getPassword().equals(u.getPassword())) {
				logger.info("Login succeded");
				System.out.println("Login succeded");
				return Response.ok(u, MediaType.APPLICATION_JSON).build();
			} else {
				logger.error("Login failed");
				System.out.println("Login failed");
				return Response.serverError().build();
			}	
		} catch (Exception e) {
			logger.error("Login failed");
			System.out.println("Login failed");
			return Response.serverError().build();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@POST
	@Path("/register")
	public Response registerUser(Usuario user) {
		try {
			tx.begin();
			try {
				pm.makePersistent(user);
				logger.info("User successfully registered");
				System.out.println("User successfully registered");
			} catch (Exception e) {
				logger.info("Register failed");
				System.out.println("Register failed");
			}
			tx.commit();
			return Response.ok().build();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
	}
}