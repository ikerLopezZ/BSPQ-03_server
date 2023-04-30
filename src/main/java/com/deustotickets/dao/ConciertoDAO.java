package com.deustotickets.dao;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.deustotickets.domain.Concierto;

/**
 * 
 * @author BSPQ-03
 *
 */
public class ConciertoDAO extends DataAccessObjectBase implements IDataAccessObject<Concierto> {
	private static ConciertoDAO instance;	
	
	public ConciertoDAO() { }
	
	public static ConciertoDAO getInstance() {
		if (instance == null) {
			instance = new ConciertoDAO();
		}		
		
		return instance;
	}
	
	@Override
	public void save(Concierto object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Concierto object) {
		super.deleteObject(object);
	}

	@Override
	public List<Concierto> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Concierto> Conciertos = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Concierto> extent = pm.getExtent(Concierto.class, true);

			for (Concierto category : extent) {
				Conciertos.add(category);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Conciertos: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return Conciertos;
	}

	@Override
	public Concierto find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		Concierto result = null; 

		try {
			tx.begin();
						
			Query query = pm.newQuery("SELECT FROM " + Concierto.class.getName() + " WHERE id == '" + param + "'");
			query.setUnique(true);
			result = (Concierto) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying an Concierto: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
	
}