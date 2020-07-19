package com.info.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info.app.model.UserRest;
import com.info.app.model.request.UpdateUserDetailRequestModel;
import com.info.app.model.request.UserDetailRequest;
import com.info.app.user.exception.UserNotFoundException;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	Map<String, UserRest> users;

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam("limit") int limit) {
		return "get users was called with a page = " + page + "And Limit = " + limit;
	}

	@GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable("userId") String userId) {
		String firstName=null;
		//
		//
		//int firstNamelen=firstName.length();
		
		if (users.containsKey(userId)) {
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Validated @RequestBody UserDetailRequest userDetailRequest) {

		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetailRequest.getFirstName());
		returnValue.setLastName(userDetailRequest.getLastName());
		returnValue.setEmail(userDetailRequest.getEmail());

		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		if (users == null)
			users = new HashMap<>();
		users.put(userId, returnValue);
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@PutMapping(value = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE

	})
	public ResponseEntity<UserRest> putUser(@Validated @RequestBody UpdateUserDetailRequestModel requestModel,
			@PathVariable("userId") String userId) {
		UserRest storedUserDetails = users.get(userId);
		if (storedUserDetails != null) {
			storedUserDetails.setFirstName(requestModel.getFirstName());
			storedUserDetails.setLastName(requestModel.getLastName());
			users.put(userId, storedUserDetails);
		} else {
			throw new UserNotFoundException("User Not Found in HashMap" + userId);
		}
		return new ResponseEntity<UserRest>(storedUserDetails, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{userId}", produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
			})
	public ResponseEntity<UserRest> deleteUser(@PathVariable("userId") String userId) {
		UserRest userRequset = users.get(userId);
		UserRest removeUsersUserRest =null;
		if (userRequset != null) {
			 removeUsersUserRest = users.remove(userId);
			return new ResponseEntity<UserRest>(removeUsersUserRest, HttpStatus.OK);
		} else {
			throw new UserNotFoundException("User Not Found in HashMap" + userId);
		}
	}
}
