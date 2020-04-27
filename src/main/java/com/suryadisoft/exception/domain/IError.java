/*
 * @(#)IError.java 1.0 Jun 3, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.domain;

/** 
 * The <code>IError</code> class is the common interface for error code enumeration object.
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
public interface IError {

	/**
	 * Gets error code.
	 * 
	 * @return	Error Code.
	 */
	public String getCode();
	
	/**
	 * Gets error message.
	 * 
	 * @return	Error Message
	 */
	public String getMessage();
	
}
