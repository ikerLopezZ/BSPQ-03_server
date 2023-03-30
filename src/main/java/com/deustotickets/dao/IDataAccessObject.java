package com.deustotickets.dao;

import java.util.List;

/**
 * 
 * @author BSPQ-03
 *
 * @param <DomainObject>
 */
public interface IDataAccessObject<DomainObject> {
	/**
	 * 
	 * @param object
	 */
	public void save(DomainObject object);
	
	/**
	 * 
	 * @param object
	 */
	public void delete(DomainObject object);
	
	/**
	 * 
	 * @return
	 */
	public List<DomainObject> getAll();
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public DomainObject find(String param);
}
