/*
 * @(#)CommonError.java 1.0 Jun 5, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.domain.type;

import com.suryadisoft.exception.domain.IError;

/** 
 * The <code>CommonError</code> class consists of the WMS generic Error constant.
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
public enum CommonError implements IError {

	UNKNOWN_ERROR("999-9999", "Undefined Error Code: {0}");
	
	private String code;
	private String message;
	
	/**
   * @param code		Error Code.
   * @param message	Error Message.
   */
  private CommonError(String code, String message) {
	  this.code = code;
	  this.message = message;
  }

	/**
   * @return the code
   */
  public String getCode() {
  	return code;
  }

	/**
   * Sets the code.
   *
   * @param code the code to set
   */
  public void setCode(String code) {
  	this.code = code;
  }

	/**
   * @return the message
   */
  public String getMessage() {
  	return message;
  }

	/**
   * Sets the message.
   *
   * @param message the message to set
   */
  public void setMessage(String message) {
  	this.message = message;
  }
	
}
