/*
 * @(#)Validator.java 1.0 Jun 6, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception;

import org.apache.commons.lang.StringUtils;

import com.suryadisoft.exception.domain.Response;

/** 
 * The <code>Validator</code> class validates test input.
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
public class Validator {

  public void validateName(String firstName, String lastName) {
		if (StringUtils.isBlank(firstName)) {
			throw new ValidationException(TestError.INVALID_NAME, new Object[] { "First" }, new Response());
		} else if (StringUtils.isBlank(lastName)) {
			throw new ValidationException(TestError.INVALID_NAME, new Object[] { "Last" }, new Response());
		}
	}
}
