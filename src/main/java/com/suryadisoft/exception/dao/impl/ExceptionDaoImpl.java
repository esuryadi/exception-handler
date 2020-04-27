/*
 * @(#)ExceptionDaoImpl.java 1.0 Jun 3, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.dao.impl;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.suryadisoft.exception.dao.ExceptionDao;

/** 
 * The <code>ExceptionDaoImpl</code> class is a data access class to get Error code db domain object
 * from database table.
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
@Resource(name="exceptionDao")
public class ExceptionDaoImpl<T> implements ExceptionDao<T> {

	@PersistenceContext
  private EntityManager entityManager;
	
	/**
   * Gets the entityManager.
   *
   * @return the entityManager
   */
  public EntityManager getEntityManager() {
  	return entityManager;
  }

	/* (non-Javadoc)
   * @see com.suryadisoft.exception.dao.ExceptionDao#load(java.lang.Class, java.lang.Object)
   */
  @Override
  public T load(Class<T> type, Object id) {
  	return entityManager.find(type, id);
  }

	/* (non-Javadoc)
   * @see com.trybx.dao.Dao#save(java.lang.Object)
   */
  @Override
  public void save(T domain) {
  	entityManager.persist(domain);
  }

	/* (non-Javadoc)
   * @see com.trybx.dao.Dao#update(java.lang.Object)
   */
  @Override
  public void update(T domain) {
	  entityManager.merge(domain);	  
  }

	/* (non-Javadoc)
   * @see com.trybx.dao.Dao#delete(java.lang.Object)
   */
  @Override
  public void delete(T domain) {
  	if (!entityManager.contains(domain)) {
  		domain = entityManager.merge(domain);
  	}
  	entityManager.remove(domain);		  
  }

}
