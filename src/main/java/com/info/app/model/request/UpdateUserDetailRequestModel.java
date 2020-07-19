package com.info.app.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUserDetailRequestModel {
	@NotNull(message = "First Name can not be null")
	private String firstName;
	@NotNull(message = "last Name can not be null")
	private String lastName;
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
	
	
}
