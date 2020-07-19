package com.info.app.user.exception.response;

import java.util.Date;

public class ExceptionResponse {

	private String message;
//	@DateTimeFormat(pattern = "yyyy:mm:dd:hh:mm:ss")
	private Date timestamp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
