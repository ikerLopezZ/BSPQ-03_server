package com.deustotickets.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.Logger;

import com.deustotickets.dao.ArtistaDAO;
import com.deustotickets.dao.ConciertoDAO;
import com.deustotickets.dao.UsuarioDAO;
import com.deustotickets.domain.Artista;
import com.deustotickets.domain.Concierto;
import com.deustotickets.domain.TipoUsuario;
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
			if(user.getTipo() == TipoUsuario.CLIENTE || user.getTipo() == TipoUsuario.GESTOR) {
				UsuarioDAO.getInstance().save(user);
			} else if (user.getTipo() == TipoUsuario.ARTISTA) {
				Artista a = new Artista(user, null, true, false);
				ArtistaDAO.getInstance().save(a);
			}
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
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@POST
	@Path("/deleteAccount")
	public Response deleteAccount(Usuario user) {
		try {
			Usuario u = UsuarioDAO.getInstance().find(user.getEmail());
			UsuarioDAO.getInstance().delete(u);
			logger.info("Account successfully deleted");
			System.out.println("Account successfully deleted");
			return Response.ok().build();
		} catch (Exception e) {
			logger.error("Account deletion failed");
			System.out.println("Account deletion failed");
			return Response.serverError().build();
		}
	}
	
	/**
	 * 
	 * @param concert
	 * @return
	 */
	@POST
	@Path("/addConcert")
	public Response addConcert(Concierto concert) {
		try {
			ConciertoDAO.getInstance().save(concert);
			logger.info("Concert successfully added");
			System.out.println("Concert successfully added");
			return Response.ok().build();
		} catch (Exception e) {
			logger.error("Concert not added");
			System.out.println("Concert not added");
			return Response.serverError().build();
		}
	}
	
	/**
	 * 
	 * @param concert
	 * @return
	 */
	@POST
	@Path("/deleteConcert")
	public Response deleteConcert(Concierto concert) {
		try {
			Concierto c = ConciertoDAO.getInstance().find(concert.getId());
			ConciertoDAO.getInstance().delete(c);
			logger.info("Concert successfully modified");
			System.out.println("Concert successfully modified");
			return Response.ok().build();
		} catch (Exception e) {
			logger.error("Concert modification failed");
			System.out.println("Account modification failed");
			return Response.serverError().build();
		}
	}
	
	/**
	 * 
	 * @param concert
	 * @return
	 */
	@POST
	@Path("/modifyConcert")
	public Response modifyConcert(Concierto concert) {
		try {
			Concierto c = ConciertoDAO.getInstance().find(concert.getId());
	
			
			Artista a = (Artista) UsuarioDAO.getInstance().find(concert.getArtista().getEmail());
			if(a != null) {
				logger.info("The artist already exists, it wont be modified");
				c.setArtista(a);
			} else {
				UsuarioDAO.getInstance().save(concert.getArtista());
				logger.info("The artist is not in the database, it will be saved");
				c.setArtista(concert.getArtista());
			}
			
			c.setAforo(concert.getAforo());
			c.setFecha(concert.getFecha());
			c.setLugar(concert.getLugar());
			
			ConciertoDAO.getInstance().save(c);
			logger.info("Concert successfully modified");
			System.out.println("Concert successfully modified");
			return Response.ok().build();
		} catch (Exception e) {
			logger.error("Concert modification failed");
			System.out.println("Account modification failed");
			return Response.serverError().build();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/getConcerts")
	public Response getConcerts() {
		try {
			List<Concierto> conciertos = (List<Concierto>) ConciertoDAO.getInstance().getAll();
			System.out.println(conciertos);
			logger.info(conciertos);
			logger.info("Got all concerts");
			System.out.println("Got all concerts");
			return Response.ok(conciertos, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			logger.error("getConcerts() failure");
			System.out.println("getConcerts() failure");
			return Response.serverError().build();
		}
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@POST
	@Path("/verifyArtist")
	public Response verifyArtist(Artista artista) {
		try {
			Artista a = ArtistaDAO.getInstance().find(artista.getEmail());
			
			if(a.isVerificada()) {
				logger.info("The artist is already verified");
				return Response.serverError().build();
			} else {
				a.setVerificada(true);
				logger.info("Artist successfully verified");
			}
			
			ArtistaDAO.getInstance().save(a);
			return Response.ok().build();
		} catch (Exception e) {
			logger.error("Artist verification failed "+ e.toString());
			System.out.println("Artist verification failed");
			return Response.serverError().build();
		}
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@POST
	@Path("/banUser")
	public Response banUser(Usuario user) {
		try {
			Usuario u = UsuarioDAO.getInstance().find(user.getEmail());
			
			if(u.isBanned()) {
				logger.info("User already banned");
			} else {
				u.setBanned(true);
				logger.info("User successfully banned");
			}
			
			UsuarioDAO.getInstance().save(u);
			return Response.ok().build();
		} catch (Exception e) {
			logger.error("Artist verification failed "+ e.toString());
			System.out.println("Artist verification failed");
			return Response.serverError().build();
		}
	}
}