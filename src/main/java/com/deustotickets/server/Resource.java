package com.deustotickets.server;

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

	public Resource() {
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
			if (user.getPassword().equals(u.getPassword())) {
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
			UsuarioDAO.getInstance().save(user);
			logger.info("User successfully registered");
			System.out.println("User successfully registered");
			return Response.ok().build();
		} catch (Exception e) {
			logger.info("Register failed");
			System.out.println("Register failed");
			return Response.serverError().build();
		}
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@POST
	@Path("/changeUsername")
	public Response changeUsername(Usuario user) {
		try {
			Usuario u = UsuarioDAO.getInstance().find(user.getEmail()); // Mirar
			u.setNombreApellidos(user.getNombreApellidos());
			UsuarioDAO.getInstance().save(u);
			logger.info("Username successfully changed");
			System.out.println("Username successfully changed");
			return Response.ok().build();
		} catch (Exception e) {
			logger.error("Username change failed");
			System.out.println("Username change failed");
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@POST
	@Path("/changePassword")
	public Response changePassword(Usuario user) {
		try {
			Usuario u = UsuarioDAO.getInstance().find(user.getEmail());
			u.setPassword(user.getPassword());
			UsuarioDAO.getInstance().save(u);
			logger.info("Password successfully changed");
			System.out.println("Password successfully changed");
			return Response.ok().build();
		} catch (Exception e) {
			logger.error("Password change failed");
			System.out.println("Password change failed");
			return Response.serverError().build();
		}
	}
	@POST
	@Path("/erase")
	public Response erase(Usuario user) {
		try {
			UsuarioDAO.getInstance().delete(user);;
			logger.info("Account erase");
			System.out.println("Account erase");
			return Response.ok().build();
		} catch (Exception e) {
			logger.error("Account not erase");
			System.out.println("Account not erase");
			return Response.serverError().build();
		}
	}
}