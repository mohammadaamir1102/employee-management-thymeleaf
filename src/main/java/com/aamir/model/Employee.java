package com.aamir.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "First Name is required")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Last Name is required")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
	@Column(name = "email")
	private String email;

	@NotBlank(message = "Salary is required")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "Invalid salary format")
	@Column(name = "salary")
	private String salary;

	@NotBlank(message = "Address is required")
	@Column(name = "address")
	private String address;

	@NotBlank(message = "Phone no is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number format")
	@Column(name = "phone")
	private String phone;

	@Column(name = "pf_amount")
	private Double pfAmount;
	
	@Column(name = "taxAmount")
	private Double taxAmount;
	
	@Column(name = "createdOn", nullable = false)
	private Timestamp createdOn;
	
	@Column(name = "updateOn")
	private Timestamp updatedOn;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getPfAmount() {
		return pfAmount;
	}

	public void setPfAmount(Double pfAmount) {
		this.pfAmount = pfAmount;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}
	

}
