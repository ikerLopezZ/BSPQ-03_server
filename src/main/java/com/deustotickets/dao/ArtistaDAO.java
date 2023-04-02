package com.deustotickets.dao;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.deustotickets.domain.Artista;

/**
 * 
 * @author BSPQ-03
 *
 */
public class ArtistaDAO extends DataAccessObjectBase implements IDataAccessObject<Artista> {
	private static ArtistaDAO instance;	
	
	private ArtistaDAO() { }
	
	public static ArtistaDAO getInstance() {
		if (instance == null) {
			instance = new ArtistaDAO();
		}		
		
		return instance;
	}
	
	@Override
	public void save(Artista object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Artista object) {
		super.deleteObject(object);
	}

	
	@Override
	public List<Artista> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Artista> Artistas = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Artista> extent = pm.getExtent(Artista.class, true);

			for (Artista category : extent) {
				Artistas.add(category);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Artistas: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return Artistas;
	}

	@Override
	public Artista find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		Artista result = null; 

		try {
			tx.begin();
						
			Query query = pm.newQuery("SELECT FROM " + Artista.class.getName() + " WHERE email == '" + param+ "'");
			query.setUnique(true);
			result = (Artista) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying an Artista: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
	
}