/*
 * @(#)ValidationExceptionHandler.java 1.0 Jun 6, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.handler;

import java.text.MessageFormat;

import com.suryadisoft.exception.ValidationException;
import com.suryadisoft.exception.domain.Response;
import com.suryadisoft.exception.handler.AbstractExceptionHandler;
import com.suryadisoft.exception.handler.ExceptionHandler;

/** 
 * The <code>ValidationExceptionHandler</code> class is an exception handler when ValidationException is thrown.
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
public class ValidationExceptionHandler extends AbstractExceptionHandler implements
    ExceptionHandler<ValidationException> {

	@Override
  public void handle(ValidationException exception) {
	  super.logError(exception);	  
	  Response response = exception.getResponse();
	  response.setErrorMessage(this.getError().getCode() + ": " + MessageFormat.format(this.getError().getMessage(), exception.getParameters()));
  }

}
