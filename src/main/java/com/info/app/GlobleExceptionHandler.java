package com.info.app;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.info.app.user.exception.UserNotFoundException;
import com.info.app.user.exception.response.ExceptionResponse;

@RestControllerAdvice(annotations = Controller.class)
public class GlobleExceptionHandler  extends ResponseEntityExceptionHandler{
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> showResponse() {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage("User Not Found Exception ");
		response.setTimestamp(new Date());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.EXPECTATION_FAILED);
	}

	
}
