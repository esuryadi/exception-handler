/*
 * @(#)ErrorUtil.java 1.0 Jun 5, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.suryadisoft.exception.domain.IError;
import com.suryadisoft.exception.domain.db.Error;
import com.suryadisoft.exception.domain.type.Category;
import com.suryadisoft.exception.domain.type.Severity;
import com.suryadisoft.exception.domain.type.CommonError;
import com.suryadisoft.exception.service.ExceptionService;

/** 
 * The <code>ErrorUtil</code> class is a utility class to get error domain object from database table.
 * 
 * <pre> 
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Edward Suryadi    Jun 5, 2013     Created.
 * </pre>
 * 
 * @author Edward Suryadi
 * @version 1.0
 */
@Component
public class ErrorUtil {

	@Autowired
	private ExceptionService exceptionService;
	
	/**
	 * Gets the error domain object given the error type.
	 * 
	 * @param error	Error Type
	 * 
	 * @return	Error Domain Object
	 */
	public Error getError(IError error) {
		Error err = exceptionService.getError(error);
		if (err == null) {
			err = exceptionService.getError(CommonError.UNKNOWN_ERROR);
			if (err == null) {
  			err = new Error(CommonError.UNKNOWN_ERROR);
  			err.setSeverity(Severity.FATAL);
  			err.setCategory(Category.SYSTEM);
  			err.setDateCreated(new Date());
  			err.setUserId("system");
  			exceptionService.storeError(err);
			}
		}
		
		return err;
	}
	
	/**
	 * Gets the list of mapped errors given the error type.
	 * 
	 * @param error	Error Type
	 * 
	 * @return	List of mapped errors
	 */
	public List<Error> getMappedErrors(IError error) {
		Set<Error> mappedErrors = exceptionService.getMappedErrors(error);
		if (mappedErrors != null) {
			return new ArrayList<Error>(mappedErrors);
		} else {
			return null;
		}
	}
	
}
