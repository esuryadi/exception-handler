/*
 * @(#)ValidatorTest.java 1.0 Jun 6, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.suryadisoft.exception.ValidationException;
import com.suryadisoft.exception.Validator;
import com.suryadisoft.exception.config.TestConfig;

/** 
 * The <code>ValidatorTest</code> class is a unit test for Validator class.
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
public class ValidatorTest {

	private Validator validator;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = TestConfig.getApplicationContext();
		this.validator = ctx.getBean(Validator.class);
	}

	/**
	 * Test method for {@link com.suryadisoft.exception.Validator#validateName(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testValidateName() {
		try {
			validator.validateName(null, "Doe");
			fail("Not yet implemented");
		} catch (ValidationException ex) {
			assertNotNull(ex.getResponse());
			assertTrue(StringUtils.isNotBlank(ex.getResponse().getErrorMessage()));
			System.out.println(ex.getResponse().getErrorMessage());
		}
	}

}
