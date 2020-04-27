/*
 * @(#)ExceptionDao.java 1.0 Jun 3, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.dao;


/** 
 * The <code>ExceptionDao</code> class is a DAO Interface for Exception DAO implementation class.
 * 
 * <pre> 
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Edward Suryadi    Jun 3, 2013     Created.
 * </pre>
 * 
 * @author Edward Suryadi
 * @version 1.0
 */
public interface ExceptionDao<T> {

	/**
	 * Retrieves db domain object given the primary key id.
	 *  
	 * @param type	DB Domain class type.
	 * @param id		Primary Key Id.
	 * 
	 * @return	Domain object.
	 */
	public T load(Class<T> type, Object id);

	/**
	 * Saves new db domain object data into database.
	 * 
	 * @param domain	DB Domain Object.
	 */
	public void save(T domain);
	
	/**
	 * Update existing db domain object data into database.
	 * 
	 * @param domain	DB Domain Object.
	 */
	public void update(T domain);
	
	/**
	 * Deletes db domain object data from the database.
	 * 
	 * @param domain	DB Domain Object.
	 */
	public void delete(T domain);

}
