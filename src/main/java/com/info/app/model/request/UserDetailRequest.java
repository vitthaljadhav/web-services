package com.info.app.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserDetailRequest {
	@NotNull(message = "First Name can not be null")
	private String firstName;
	@NotNull(message = "last Name can not be null")
	private String lastName;
	@NotNull(message = "Email  can not be null")
	@Email
	private String email;
	private String userId;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
