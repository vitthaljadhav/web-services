package com.info.app.user.exception;

import ch.qos.logback.core.db.dialect.MsSQLDialect;

public class UserNotFoundException extends RuntimeException {
	private String message;
	
	public UserNotFoundException(String message) {
		super(message);
		this.message=message;
	}

}
