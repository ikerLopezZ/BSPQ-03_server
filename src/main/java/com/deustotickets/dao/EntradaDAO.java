package com.deustotickets.dao;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.deustotickets.domain.Entrada;

public class EntradaDAO extends DataAccessObjectBase implements IDataAccessObject<Entrada> {
	private static EntradaDAO instance;	
	
	public EntradaDAO() { }
	
	public static EntradaDAO getInstance() {
		if (instance == null) {
			instance = new EntradaDAO();
		}		
		
		return instance;
	}
	
	@Override
	public void save(Entrada object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Entrada object) {
		super.deleteObject(object);
	}

	@Override
	public List<Entrada> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Entrada> Entradas = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Entrada> extent = pm.getExtent(Entrada.class, true);

			for (Entrada category : extent) {
				Entradas.add(category);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Entradas: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return Entradas;
	}

	@Override
	public Entrada find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		Entrada result = null; 

		try {
			tx.begin();
						
			Query query = pm.newQuery("SELECT FROM " + Entrada.class.getName() + " WHERE id == '" + param+"'");
			query.setUnique(true);
			result = (Entrada) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying an Entrada: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
	
}