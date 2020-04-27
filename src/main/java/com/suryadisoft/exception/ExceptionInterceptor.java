/*
 * @(#)ExceptionInterceptor.java 1.0 Jun 5, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.suryadisoft.exception.handler.ExceptionHandler;
import com.suryadisoft.exception.handler.UnknownExceptionHandler;

/** 
 * The <code>ExceptionInterceptor</code> class is an exception interceptor class to intercept
 * exception and forward to exception handler to handle it.
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
@Aspect
public class ExceptionInterceptor implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	/**
	 * Handle the exception.
	 * 
	 * @param jointPoint	JointPoint object
	 * @param exception		Exception object
	 */
	@AfterThrowing
	public void handleException(JoinPoint jointPoint, Exception exception) {
		try {
  		if (exception instanceof CommonException) {
  			String id = ((CommonException) exception).getExceptionHandlerId().getSimpleName();
  			try {
    			@SuppressWarnings("unchecked")
          ExceptionHandler<CommonException> exceptionHandler = (ExceptionHandler<CommonException>) applicationContext.getBean(id);
   				exceptionHandler.handle((CommonException) exception);
  			} catch (NoSuchBeanDefinitionException ex) {
  				throw new Error("Exception Handler " + id + " does not exist!");
  			}
  		} else {
  			UnknownExceptionHandler exceptionHandler = (UnknownExceptionHandler) applicationContext.getBean("Exception");
  			exceptionHandler.handle(exception);
  		}
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	/* (non-Javadoc)
   * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext)
      throws BeansException {
	  this.applicationContext = applicationContext;	  
  }
	
}
