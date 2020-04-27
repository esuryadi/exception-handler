/*
 * @(#)ExceptionConfig.java 1.0 Jun 3, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.suryadisoft.exception.ExceptionInterceptor;
import com.suryadisoft.exception.dao.ExceptionDao;
import com.suryadisoft.exception.dao.impl.ExceptionDaoImpl;
import com.suryadisoft.exception.domain.db.Error;
import com.suryadisoft.exception.service.ExceptionService;
import com.suryadisoft.exception.service.impl.ExceptionServiceImpl;
import com.suryadisoft.exception.util.ErrorUtil;

/** 
 * The <code>ExceptionConfig</code> class is an annotation based Spring Framework Configuration for
 * the Exception Handler Framework.
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
@Configuration
@ImportResource("classpath:exception-config.xml")
@Import(ExceptionHandlerConfig.class)
public class ExceptionConfig {

	private @Value("${jdbc.driver.class.name}") String driverClassName;
	private @Value("${jdbc.url}") String url;
	private @Value("${jdbc.username}") String user;
	private @Value("${jdbc.password}") String password;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		
		return emf;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return txManager;
	}
	
	@Bean
	public ExceptionDao<Error> errorDao() {
		return new ExceptionDaoImpl<Error>();
	}
	
	@Bean
	public ExceptionService exceptionService() {
		return new ExceptionServiceImpl();
	}
	
	@Bean
	public ErrorUtil errorUtil() {
		return new ErrorUtil();
	}
	
	@Bean(name="exceptionInterceptor")
	public ExceptionInterceptor exceptionInterceptor() {
		return new ExceptionInterceptor();
	}
	
	static public ApplicationContext getApplicationContext() {
		return new AnnotationConfigApplicationContext(ExceptionConfig.class);
	}
	
}
