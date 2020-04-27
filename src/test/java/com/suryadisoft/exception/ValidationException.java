/*
 * @(#)ValidationException.java 1.0 Jun 6, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception;

import com.suryadisoft.exception.CommonException;
import com.suryadisoft.exception.domain.IError;
import com.suryadisoft.exception.domain.Response;

/** 
 * The <code>ValidationException</code> class is an exception that is thrown when unit test is failing.
 * 
 * <pre> 
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Edward Suryadi    Jun 6, 2013     Created.
 * </pre>
 * 
 * @author Edward Suryadi
 * @version 1.0
 */
public class ValidationException extends CommonException {

  private static final long serialVersionUID = -5910668995278780445L;

  private Response response;
  
	/**
   * @param error
   * @param parameters
   * @param	response
   */
  public ValidationException(IError error, Object[] parameters, Response response) {
	  super(error, parameters);
	  this.response = response;
  }

	/**
   * @param error
   */
  public ValidationException(IError error, Response response) {
	  super(error);
	  this.response = response;
  }

	/**
   * @return the response
   */
  public Response getResponse() {
  	return response;
  }

	/**
   * Sets the response.
   *
   * @param response the response to set
   */
  public void setResponse(Response response) {
  	this.response = response;
  }

	/* (non-Javadoc)
   * @see com.suryadisoft.exception.CommonException#getExceptionHandlerId()
   */
  @Override
  public Class<?> getExceptionHandlerId() {
	  return ValidationException.class;
  }

}
