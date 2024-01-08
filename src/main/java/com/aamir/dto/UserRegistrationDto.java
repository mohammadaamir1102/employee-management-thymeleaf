package com.aamir.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserRegistrationDto {
	
	@NotBlank(message = "First Name cannot be blank")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be blank")
	private String lastName;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
	private String email;
	
	@Pattern(
	        regexp = "^(?=.*[A-Z])(?=.*[a-z]{3,})(?=.*[0-9])(?=.*[!@#$%^&*()-_+=]).{6,}$",
	        message = "Password must have at least 6 characters, 1 uppercase, 3 lowercase, 1 digit, and 1 special symbol."
	    )
	private String password;
	
	public UserRegistrationDto(){
		
	}
	
	public UserRegistrationDto(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
