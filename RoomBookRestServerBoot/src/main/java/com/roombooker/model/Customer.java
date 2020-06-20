package com.roombooker.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * @author Prathap Phillips
 *
 */
/** All Db operation for a Customer with be done with this Entity */
@Entity
@Table(name = "customers", schema = "roombook")
@NamedQueries({ @NamedQuery(name = "@getAllCustomer", query = "From Customer") })
public class Customer{
		
	/* Unique id per customer for bookkeeping */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	/* Customer’s First Name */
	@Column
	@NotNull
    @NotEmpty
	@Size(min=4,max=50,message="First Name:Must be 4-50 characters long")
	private String firstname;
	/* Customer’s Last Name */
	@Column
	@NotNull
    @NotEmpty
	@Size(min=4,max=50,message="Last Name:Must be 4-50 characters long")
	private String lastname;
	/* Customer’s Date Of Birth */
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	/* Customer’s Email Id to uniquely identify and contact the customer */
	@Column(unique = true)
	@NotNull
    @NotEmpty
    @Size(min=8,max=50,message="EMail ID:Must be 8-50 characters long")
	@Email(regexp = ".+@.+\\..+")
	private String email;
	/*
	 * Customer’s password to login / enter into the booking system. Should ​be
	 * between 8 to 10 characters
	 */
	@Column
	@NotNull
    @NotEmpty
	@Size(min=8,max=10,message="Password Format")
	private String password;
	
	public Customer() {

	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", email=" + email + ", password=" + password + "]";
	}
	
	
	public void copyCustomer(Customer customer) {
		this.firstname=customer.getFirstname();
		this.lastname=customer.getLastname();
		this.dob=customer.getDob();
		this.email=customer.email;
		this.password=customer.getPassword();
	}
	
	

}
