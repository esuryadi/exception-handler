/*
 * @(#)AbstractExceptionHandler.java 1.0 Jun 5, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.handler;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.suryadisoft.exception.CommonException;
import com.suryadisoft.exception.domain.db.Error;
import com.suryadisoft.exception.domain.type.CommonError;
import com.suryadisoft.exception.util.ErrorUtil;

/** 
 * The <code>AbstractExceptionHandler</code> class is TODO
 * 
 * <pre> 
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Edward Suryadi    Jun 5, 2013    Created.
 * </pre>
 * 
 * @author Edward Suryadi
 * @version 1.0
 */
public abstract class AbstractExceptionHandler {

	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private ErrorUtil errorUtil;
	private Error error;
		
	/**
   * @return the error
   */
  public Error getError() {
  	return error;
  }

	/**
   * Sets the error.
   *
   * @param error the error to set
   */
  public void setError(Error error) {
  	this.error = error;
  }

	/**
   * @return the errorUtil
   */
  public ErrorUtil getErrorUtil() {
  	return errorUtil;
  }

  /**
   * Logs the error to error file given the Error Object Interface and Error Message Parameters.
   * 
   * @param error				Error Object Interface
   * @param parameters	Error Message Parameters
   */
	protected void logError(CommonException exception) {
		this.error = errorUtil.getError(exception.getError());
		StringBuilder strbld = new StringBuilder();
		strbld.append("\n");
		strbld.append("Error Code: " + this.error.getCode() + "\n");
		if (this.error.getCode().equals(CommonError.UNKNOWN_ERROR)) {
			strbld.append("Error Message: " + MessageFormat.format(this.error.getMessage(), new Object[] { this.error.getCode() }) + "\n");
		} else {
			strbld.append("Error Message: " + MessageFormat.format(this.error.getMessage(), exception.getParameters()) + "\n");
		}
		strbld.append("Error Severity: " + this.error.getSeverity() + "\n");
		strbld.append("Error Category: " + this.error.getCategory());
		log.error(strbld.toString());
		log.error("Exception Stack Trace:", exception);
	}
	
}
