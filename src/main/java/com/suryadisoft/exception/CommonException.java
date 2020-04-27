/*
 * @(#)CommonException.java 1.0 Jun 5, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception;

import java.text.MessageFormat;

import com.suryadisoft.exception.domain.IError;

/** 
 * The <code>CommonException</code> class is the root exception for all WMS exceptions.
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
public class CommonException extends RuntimeException {

  private static final long serialVersionUID = 7309547389748249568L;

  private IError error;
  private Object[] parameters;
  
	/**
	 * Create an instance of CommonException given the error object interface.
	 * 
   * @param error	Error Object Interface
   */
  public CommonException(IError error) {
	  super("Error " + error.getCode() + ((error.getMessage() != null) ? ": " + error.getMessage() : ""));
	  this.error = error;
  }

	/**
	 * Create an instance of CommonException given the error object interface and error message parameters.
	 * 
   * @param error				Error Object Interface
   * @param parameters	Error Message Parameters
   */
  public CommonException(IError error, Object[] parameters) {
  	super("Error " + error.getCode() + ((error.getMessage() != null) ? ": " + MessageFormat.format(error.getMessage(), parameters) : ""));
	  this.error = error;
	  this.parameters = parameters;
  }

	/**
	 * Create an instance of CommonException given the error object interface and throwable cause.
	 * 
	 * @param	error	Error Object Interface
   * @param cause	Throwable Cause
   */
  public CommonException(IError error, Throwable cause) {	  
  	super("Error " + error.getCode() + ((error.getMessage() != null) ? ": " + error.getMessage() : ""), cause);
	  this.error = error;
  }
  
  /**
   * Create an instance of CommonException given the error object interface, error message parameters, and the throwable cause.
   * 
   * @param error				Error Object Interface
   * @param	parameters	Error Message Parameters
   * @param cause				Throwable Cause
   */
  public CommonException(IError error, Object[] parameters, Throwable cause) {
  	super("Error " + error.getCode() + ((error.getMessage() != null) ? ": " + MessageFormat.format(error.getMessage(), parameters) : ""), cause);
	  this.error = error;
	  this.parameters = parameters;
  }

	/**
	 * Gets the Error Object Interface.
	 * 
   * @return Error Object Interface
   */
  public IError getError() {
  	return error;
  }
  
	/**
   * Sets the Error Object Interface.
   *
   * @param error the error object interface to set
   */
  public void setError(IError error) {
  	this.error = error;
  }

	/**
	 * Gets the Error Message Parameters.
	 * 
   * @return the error message parameters
   */
  public Object[] getParameters() {
  	return parameters;
  }

	/**
   * Sets the error message parameters.
   *
   * @param parameters the error message parameters to set
   */
  public void setParameters(Object[] parameters) {
  	this.parameters = parameters;
  }
  
  /**
   * Gets the exception handler id by exception class type.
   * 
   * @return	Exception Class Type.
   */
  public Class<?> getExceptionHandlerId() {
  	return CommonException.class;
  }
  
}
