package com.deustotickets.dao;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.deustotickets.domain.Usuario;

public class UsuarioDAO extends DataAccessObjectBase implements IDataAccessObject<Usuario> {
	private static UsuarioDAO instance;	
	
	public UsuarioDAO() { }
	
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}			
		return instance;
	}
	
	@Override
	public void save(Usuario object) { 
		super.saveObject(object);
	}

	@Override
	public void delete(Usuario object) {
		super.deleteObject(object);
	}

	@Override
	public List<Usuario> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Usuario> Usuarios = new ArrayList<>();
		try {
			tx.begin();
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario category : extent) {
				Usuarios.add(category);
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Usuarios: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return Usuarios;
	}

	@Override
	public Usuario find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Usuario result = null; 
		try {
			tx.begin();		
			Query query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + param+"'");
			query.setUnique(true);
			result = (Usuario) query.execute();
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying an Usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return result;
	}
}