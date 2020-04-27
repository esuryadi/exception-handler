/*
 * @(#)ExceptionHandlerConfig.java 1.0 Jun 5, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.suryadisoft.exception.CommonException;
import com.suryadisoft.exception.handler.ExceptionHandler;
import com.suryadisoft.exception.handler.UnknownExceptionHandler;
import com.suryadisoft.exception.handler.CommonExceptionHandler;

/** 
 * The <code>ExceptionHandlerConfig</code> class is a spring context configuration for Exception
 * Handler Bean.
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
@Configuration
public class ExceptionHandlerConfig {

	@Bean(name="CommonException")
	public ExceptionHandler<CommonException> wmsExceptionHandler() {
		return new CommonExceptionHandler();
	}
	
	@Bean(name="Exception")
	public UnknownExceptionHandler unknownExceptionHandler() {
		return new UnknownExceptionHandler();
	}
	
}
