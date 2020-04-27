/*
 * @(#)ErrorUtilTest.java 1.0 Jun 5, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.suryadisoft.exception.TestError;
import com.suryadisoft.exception.config.ExceptionConfig;
import com.suryadisoft.exception.domain.db.Error;
import com.suryadisoft.exception.service.ExceptionService;
import com.suryadisoft.exception.util.ErrorUtil;

/** 
 * The <code>ErrorUtilTest</code> class is a unit test for Error Util class.
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
public class ErrorUtilTest {
	
	private ErrorUtil errorUtil;
	private ExceptionService exceptionService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = ExceptionConfig.getApplicationContext();
		this.errorUtil = ctx.getBean(ErrorUtil.class);
		this.exceptionService = ctx.getBean(ExceptionService.class);
	}

	/**
	 * Test method for {@link com.suryadisoft.exception.util.ErrorUtil#getError(com.suryadisoft.exception.domain.IError)}.
	 */
	@Test
	public void testGetError() {
		Error error = errorUtil.getError(TestError.VALIDATION_ERR);
		assertNotNull(error);
		assertNotEquals(TestError.VALIDATION_ERR.getCode(), error.getCode());
		error = errorUtil.getError(TestError.INVALID_NAME);
		assertNotNull(error);
		assertEquals(TestError.INVALID_NAME.getCode(), error.getCode());
	}

	/**
	 * Test method for {@link com.suryadisoft.exception.util.ErrorUtil#getMappedErrors(com.suryadisoft.exception.domain.IError)}.
	 */
	@Test
	public void testGetMappedErrors() {
		Error error = new Error(TestError.VALIDATION_ERR);
		error.setMappedErrors(new HashSet<Error>());
		error.getMappedErrors().add(new Error(TestError.INVALID_NAME));
		error.getMappedErrors().add(new Error(TestError.INVALID_ADDRESS));
		exceptionService.updateError(error);
		List<Error> mappedErrors = errorUtil.getMappedErrors(TestError.VALIDATION_ERR);
		assertNotNull(mappedErrors);
		assertTrue(mappedErrors.size() == 2);
		exceptionService.deleteError(error);
	}

}
