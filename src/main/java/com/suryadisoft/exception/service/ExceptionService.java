/*
 * @(#)ExceptionService.java 1.0 Jun 3, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.service;

import java.util.Set;

import com.suryadisoft.exception.domain.IError;
import com.suryadisoft.exception.domain.db.Error;

/** 
 * The <code>ExceptionService</code> class is a service interface for the exception service 
 * implementation class.
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
public interface ExceptionService {

	/**
	 * Store error code info to database table.
	 * 
	 * @param error	Error db domain object.
	 */
	public void storeError(Error error);
	
	/**
	 * Update error code info in database table.
	 * 
	 * @param error	Error db domain object.
	 */
	public void updateError(Error error);
	
	/**
	 * Delete error code from database table.
	 * 
	 * @param error	Error db domain object.
	 */
	public void deleteError(Error error);

	/**
	 * Gets the error code info given the error interface.
	 * 
	 * @param error	Error Interface.
	 * 
	 * @return	Error db domain object.
	 */
	public Error getError(IError error);
	
	/**
	 * Gets the list of mapped error codes given the error interface.
	 * 
	 * @param error	Error Interface.
	 * 
	 * @return	Set of Error db domain objects.
	 */
	public Set<Error> getMappedErrors(IError error);
	
}
