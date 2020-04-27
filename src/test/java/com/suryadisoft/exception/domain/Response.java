/*
 * @(#)Response.java 1.0 Jun 6, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.domain;


/** 
 * The <code>Response</code> class is a test response object.
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
public class Response {

	private String errorMessage;

	/**
   * @return the errorMessage
   */
  public String getErrorMessage() {
  	return errorMessage;
  }

	/**
   * Sets the errorMessage.
   *
   * @param errorMessage the errorMessage to set
   */
  public void setErrorMessage(String errorMessage) {
  	this.errorMessage = errorMessage;
  }

}
