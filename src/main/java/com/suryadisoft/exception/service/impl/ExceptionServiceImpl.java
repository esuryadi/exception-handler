/*
 * @(#)ExceptionServiceImpl.java 1.0 Jun 3, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.suryadisoft.exception.dao.ExceptionDao;
import com.suryadisoft.exception.domain.IError;
import com.suryadisoft.exception.domain.db.Error;
import com.suryadisoft.exception.service.ExceptionService;

/** 
 * The <code>ExceptionServiceImpl</code> class is an exception service implementation class to store,
 * update, delete, and get the error code information.
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
@Service("exceptionService")
public class ExceptionServiceImpl implements ExceptionService {

	@Autowired
	private ExceptionDao<Error> errorDao;
	
	/* (non-Javadoc)
	 * @see com.suryadisoft.exception.service.ExceptionService#storeError(com.suryadisoft.exception.domain.db.Error)
	 */
	@Override
	@Transactional(rollbackFor = DataAccessException.class, 
			 readOnly = false, 
			 timeout = 30, 
			 propagation = Propagation.REQUIRED)
	public void storeError(Error error) {
		errorDao.save(error);
	}

	/* (non-Javadoc)
	 * @see com.suryadisoft.exception.service.ExceptionService#updateError(com.suryadisoft.exception.domain.db.Error)
	 */
	@Override
	@Transactional(rollbackFor = DataAccessException.class, 
			 readOnly = false, 
			 timeout = 30, 
			 propagation = Propagation.REQUIRED)
	public void updateError(Error error) {
		errorDao.update(error);
	}

	/* (non-Javadoc)
	 * @see com.suryadisoft.exception.service.ExceptionService#deleteError(com.suryadisoft.exception.domain.db.Error)
	 */
	@Override
	@Transactional(rollbackFor = DataAccessException.class, 
			 readOnly = false, 
			 timeout = 30, 
			 propagation = Propagation.REQUIRED)
	public void deleteError(Error error) {
		errorDao.delete(error);
	}

	/* (non-Javadoc)
	 * @see com.suryadisoft.exception.service.ExceptionService#getError(com.suryadisoft.exception.domain.IError)
	 */
	@Override
	@Transactional(readOnly = true, 
			 timeout = 30, 
			 propagation = Propagation.SUPPORTS)
	public Error getError(IError error) {
		try {	
			Error err = errorDao.load(Error.class, error.getCode());			
			if (err != null) {
				return new Error(err);
			}
  	} catch (NoResultException ex) {
  		
  	} 	
  	
  	return null;
	}

	/* (non-Javadoc)
	 * @see com.suryadisoft.exception.service.ExceptionService#getMappedErrors(com.suryadisoft.exception.domain.IError)
	 */
	@Override
	@Transactional(readOnly = true, 
			 timeout = 30, 
			 propagation = Propagation.SUPPORTS)
	public Set<Error> getMappedErrors(IError error) {
		try {
  		Error err = errorDao.load(Error.class, error.getCode());
  		Set<Error> mappedErrors = new HashSet<Error>();
  		for (Error mappedError : err.getMappedErrors()) {
  			mappedErrors.add(new Error(mappedError));
  		}
  		return mappedErrors;
  	} catch (NoResultException ex) {
  		return null;
  	}
	}

}
