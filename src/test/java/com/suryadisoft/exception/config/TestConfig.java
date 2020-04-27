/*
 * @(#)TestConfig.java 1.0 Jun 6, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.suryadisoft.exception.Validator;
import com.suryadisoft.exception.config.ExceptionConfig;
import com.suryadisoft.exception.handler.ValidationExceptionHandler;

/** 
 * The <code>TestConfig</code> class is a spring test configuration class.
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
@Configuration
@Import(ExceptionConfig.class)
public class TestConfig {

	@Bean(name="ValidationException")
	public ValidationExceptionHandler validationExceptionHandler() {
		return new ValidationExceptionHandler();
	}
	
	@Bean
	public Validator validator() {
		return new Validator();
	}
	
	static public ApplicationContext getApplicationContext() {
		return new AnnotationConfigApplicationContext(TestConfig.class);
	}
	
}
