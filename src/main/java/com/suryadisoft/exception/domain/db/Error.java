/*
 * @(#)Error.java 1.0 Jun 3, 2013
 * Copyrights 2013 MIDAS. All rights reserved.
 * MIDAS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suryadisoft.exception.domain.db;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.suryadisoft.exception.domain.IError;
import com.suryadisoft.exception.domain.type.Category;
import com.suryadisoft.exception.domain.type.Severity;

/** 
 * The <code>Error</code> class is a database domain object that represents error table.
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
@Entity
@Table(name="ERROR")
public class Error implements Serializable {

  private static final long serialVersionUID = -4285081499119979668L;

  @Id
	@Column(unique = true, nullable = false)
	private String code;
  
  @Column(unique=false, nullable=true, length=500)
  private String message;
  
  @Enumerated(EnumType.STRING)
  private Severity severity;
  
  @Enumerated(EnumType.STRING)
  private Category category;
    
  @ManyToMany(
    targetEntity=Error.class,
    cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH }
  )
  @JoinTable(
    name="error_mapping",
    joinColumns=@JoinColumn(name="source_fk"),
    inverseJoinColumns=@JoinColumn(name="target_fk")
  )    
	private Set<Error> mappedErrors;

	@Column(unique = false, nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Column(unique = false, nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dateModified;
	
	@Column(unique=false, nullable=true, length=100)
  private String userId;

	/**
	 * Creates an instance of Error class.
	 */
	public Error() {
  }
	
	/**
	 * Creates an instance of error class given by the Error DB domain object.
	 * This constructor creates a duplicate detached object of Error DB domain object.
	 * 
	 * @param error	Error DB Domain Object
	 */
	public Error(Error error) {
		this.code = error.getCode();
		this.message = error.getMessage();
		this.severity = error.getSeverity();
		this.category = error.getCategory();
		this.dateCreated = error.getDateCreated();
		this.dateModified = error.getDateModified();
		this.userId = error.getUserId();
  }

	/**
	 * Creates an instance of Error class given the Error Object Interface.
	 * 
	 * @param error	Error Object Interface
	 */
	public Error(IError error) {
	  this.code = error.getCode();
	  this.message = error.getMessage();
  }

	/**
	 * Creates an instance of Error class given the Error Object Interface, Severity Type, and Category Type.
	 * 
	 * @param error			Error Object Interface
	 * @param severity	Severity Type Constant
	 * @param category	Category Type Constant
	 */
	public Error(IError error, Severity severity, Category category) {
	  this.code = error.getCode();
	  this.message = error.getMessage();
	  this.severity = severity;
	  this.category = category;
  }

	/**
   * @return the code
   */
  public String getCode() {
  	return code;
  }

	/**
   * Sets the code.
   *
   * @param code the code to set
   */
  public void setCode(String code) {
  	this.code = code;
  }

	/**
   * @return the message
   */
  public String getMessage() {
  	return message;
  }

	/**
   * Sets the message.
   *
   * @param message the message to set
   */
  public void setMessage(String message) {
  	this.message = message;
  }

	/**
   * @return the severity
   */
  public Severity getSeverity() {
  	return severity;
  }

	/**
   * Sets the severity.
   *
   * @param severity the severity to set
   */
  public void setSeverity(Severity severity) {
  	this.severity = severity;
  }

	/**
   * @return the category
   */
  public Category getCategory() {
  	return category;
  }

	/**
   * Sets the category.
   *
   * @param category the category to set
   */
  public void setCategory(Category category) {
  	this.category = category;
  }

	/**
   * @return the mappedErrors
   */
  public Set<Error> getMappedErrors() {
  	return mappedErrors;
  }

	/**
   * Sets the mappedErrors.
   *
   * @param mappedErrors the mappedErrors to set
   */
  public void setMappedErrors(Set<Error> mappedErrors) {
  	this.mappedErrors = mappedErrors;
  }

	/**
   * @return the dateCreated
   */
  public Date getDateCreated() {
  	return dateCreated;
  }

	/**
   * Sets the dateCreated.
   *
   * @param dateCreated the dateCreated to set
   */
  public void setDateCreated(Date dateCreated) {
  	this.dateCreated = dateCreated;
  }

	/**
   * @return the dateModified
   */
  public Date getDateModified() {
  	return dateModified;
  }

	/**
   * Sets the dateModified.
   *
   * @param dateModified the dateModified to set
   */
  public void setDateModified(Date dateModified) {
  	this.dateModified = dateModified;
  }

	/**
   * @return the userId
   */
  public String getUserId() {
  	return userId;
  }

	/**
   * Sets the userId.
   *
   * @param userId the userId to set
   */
  public void setUserId(String userId) {
  	this.userId = userId;
  }
	
}
