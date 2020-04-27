/*
 * @(#)TestError.java 1.0 Jun 3, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception;

import com.suryadisoft.exception.domain.IError;

/** 
 * The <code>TestError</code> class is a test error constant class.
 * class.
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
public enum TestError implements IError {
	VALIDATION_ERR("A123", "Validation Error!"),
	INVALID_NAME("B123", "{0} Name is required!"),
	INVALID_ADDRESS("C123", "Address is required!");
	
	private String code;
	private String message;
	
	TestError(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/* (non-Javadoc)
   * @see com.suryadisoft.exception.domain.IError#getCode()
   */
  @Override
  public String getCode() {
    return this.code;
  }

	/* (non-Javadoc)
   * @see com.suryadisoft.exception.domain.IError#getMessage()
   */
  @Override
  public String getMessage() {
    return this.message;
  }		
  
}