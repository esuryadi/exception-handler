/*
 * @(#)ExceptionHandler.java 1.0 Jun 5, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.handler;

import com.suryadisoft.exception.CommonException;

/** 
 * The <code>ExceptionHandler</code> class is an interface for Exception Handler implementation.
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
public interface ExceptionHandler<T extends CommonException> {

	/**
	 * Handle the exception.
	 * 
	 * @param exception	CommonException type.
	 */
	public void handle(T exception);
	
}
