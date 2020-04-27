/*
 * @(#)UnknownExceptionHandler.java 1.0 Jun 5, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suryadisoft.exception.domain.type.Category;
import com.suryadisoft.exception.domain.type.Severity;
import com.suryadisoft.exception.domain.type.CommonError;

/** 
 * The <code>UnknownExceptionHandler</code> class is an exception handler for unknown exception or
 * exception that is not extend CommonException.
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
public class UnknownExceptionHandler {
	
	private Logger log = LoggerFactory.getLogger(UnknownExceptionHandler.class);

	/**
	 * Handles Unknown Exception or non CommonException type.
	 * 
	 * @param exception	Exception object
	 */
	public void handle(Exception exception) {
		StringBuilder strbld = new StringBuilder();
		strbld.append("\n\n");
		strbld.append("Error Code: " + CommonError.UNKNOWN_ERROR.getCode() + "\n");
		strbld.append("Error Message: " + exception.getMessage() + "\n");
		strbld.append("Error Severity: " + Severity.FATAL + "\n");
		strbld.append("Error Category: " + Category.SYSTEM);
		strbld.append("\n");
		log.error(strbld.toString());
		log.error("Exception Stack Trace:", exception);
	}
	
}
