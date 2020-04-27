/*
 * @(#)ExceptionServiceTest.java 1.0 Jun 3, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;

import com.suryadisoft.exception.TestError;
import com.suryadisoft.exception.config.ExceptionConfig;
import com.suryadisoft.exception.domain.db.Error;
import com.suryadisoft.exception.domain.type.Category;
import com.suryadisoft.exception.domain.type.Severity;
import com.suryadisoft.exception.service.ExceptionService;

/** 
 * The <code>ExceptionServiceTest</code> class is a unit test for Exception Service Implementation
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExceptionServiceTest {

	private ExceptionService exceptionService;
	private Error error;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = ExceptionConfig.getApplicationContext();
		this.exceptionService = ctx.getBean(ExceptionService.class);
		this.error = new Error(TestError.VALIDATION_ERR);
		this.error.setSeverity(Severity.MINOR);
		this.error.setCategory(Category.BUSINESS_RULE);
		this.error.setDateCreated(new Date());
		this.error.setUserId("user1");
	}

	/**
	 * Test method for {@link com.suryadisoft.exception.service.impl.ExceptionServiceImpl#storeError(com.suryadisoft.exception.domain.db.Error)}.
	 */
	@Test
	public void test1StoreError() {
		exceptionService.storeError(error);
		Error storedError = exceptionService.getError(TestError.VALIDATION_ERR);
		assertNotNull(storedError.getCode());
		assertEquals(TestError.VALIDATION_ERR.getCode(), storedError.getCode());
		assertEquals(TestError.VALIDATION_ERR.getMessage(), storedError.getMessage());
		assertNull(storedError.getDateModified());
		assertNull(storedError.getMappedErrors());
	}

	/**
	 * Test method for {@link com.suryadisoft.exception.service.impl.ExceptionServiceImpl#updateError(com.suryadisoft.exception.domain.db.Error)}.
	 */
	@Test
	public void test2UpdateError() {
		error.setDateModified(new Date());
		error.setSeverity(Severity.WARNING);
		error.setMappedErrors(new HashSet<Error>());
		error.getMappedErrors().add(new Error(TestError.INVALID_NAME, Severity.WARNING, Category.BUSINESS_RULE));
		error.getMappedErrors().add(new Error(TestError.INVALID_ADDRESS, Severity.WARNING, Category.BUSINESS_RULE));
		exceptionService.updateError(error);		
		Error updatedError = exceptionService.getError(TestError.VALIDATION_ERR);
		assertNotNull(updatedError.getDateModified());
		assertTrue(updatedError.getSeverity() == Severity.WARNING);
	}

	/**
	 * Test method for {@link com.suryadisoft.exception.service.impl.ExceptionServiceImpl#getError(com.suryadisoft.exception.domain.IError)}.
	 */
	@Test
	public void test3GetError() {
		Error error = exceptionService.getError(TestError.VALIDATION_ERR);
		assertNotNull(error);
		assertEquals(TestError.VALIDATION_ERR.getCode(), error.getCode());
		assertEquals(TestError.VALIDATION_ERR.getMessage(), error.getMessage());
		assertTrue(error.getSeverity() == Severity.WARNING);
		assertTrue(error.getCategory() == Category.BUSINESS_RULE);
		assertNotNull(error.getDateCreated());
		assertNotNull(error.getDateModified());
	}

	/**
	 * Test method for {@link com.suryadisoft.exception.service.impl.ExceptionServiceImpl#getMappedErrors(com.suryadisoft.exception.domain.IError)}.
	 */
	@Test
	public void test4GetMappedErrors() {
		Set<Error> mappedErrors = exceptionService.getMappedErrors(TestError.VALIDATION_ERR);
		assertNotNull(mappedErrors);
		assertTrue(mappedErrors.size() == 2);
	}
	
	/**
	 * Test method for {@link com.suryadisoft.exception.service.impl.ExceptionServiceImpl#deleteError(com.suryadisoft.exception.domain.db.Error)}.
	 */
	@Test
	public void test5DeleteError() {
		exceptionService.deleteError(error);
		Error deletedError = exceptionService.getError(TestError.VALIDATION_ERR);
		assertNull(deletedError);
	}
	
}
