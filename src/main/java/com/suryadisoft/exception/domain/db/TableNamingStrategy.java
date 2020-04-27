/*
 * @(#)TableNamingStrategy.java 1.0 May 29, 2013
 * Copyrights 2013 MIDAS, LLC. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.domain.db;

import org.hibernate.cfg.ImprovedNamingStrategy;

/** 
 * The <code>TableNamingStrategy</code> class is a Hibernate database table naming utility that
 * allows Hibernate to customize the table and column name creation based on certain convention.
 * 
 * <pre> 
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Edward Suryadi    May 29, 2013    Created.
 * </pre>
 * 
 * @author Edward Suryadi
 * @version 1.0
 */

public class TableNamingStrategy extends ImprovedNamingStrategy {

	private static final long serialVersionUID = 9017750742906809990L;
	
	private String currentTablePrefix;

	/* (non-Javadoc)
   * @see org.hibernate.cfg.ImprovedNamingStrategy#classToTableName(java.lang.String)
   */
  @Override
  public String classToTableName(String className) {
  	this.currentTablePrefix = className.toUpperCase() + "_";    
    return tableName(className);
  }

	/* (non-Javadoc)
   * @see org.hibernate.cfg.ImprovedNamingStrategy#columnName(java.lang.String)
   */
  @Override
  public String columnName(String columnName) {
  	return addUnderscores(columnName).toUpperCase();
  }

	/* (non-Javadoc)
   * @see org.hibernate.cfg.ImprovedNamingStrategy#propertyToColumnName(java.lang.String)
   */
  @Override
  public String propertyToColumnName(String propertyName) {
  	return currentTablePrefix + addUnderscores(propertyName).toUpperCase();
  }

	/* (non-Javadoc)
   * @see org.hibernate.cfg.ImprovedNamingStrategy#tableName(java.lang.String)
   */
  @Override
  public String tableName(String tableName) {
  	this.currentTablePrefix = tableName.toUpperCase() + "_";
    return addUnderscores(tableName).toUpperCase();
  }

}
