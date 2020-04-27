/*
 * @(#)CommonExceptionHandler.java 1.0 Jun 5, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.handler;

import com.suryadisoft.exception.CommonException;

/** 
 * The <code>CommonExceptionHandler</code> class is an exception handler to handle CommonException.
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
public class CommonExceptionHandler extends AbstractExceptionHandler implements ExceptionHandler<CommonException> {

	/**
	 * Handle CommonException type.
	 * 
	 * @param	exception	CommonException object
	 */
	@Override
  public void handle(CommonException exception) {
	  logError(exception);	  
  }

}
