package com.dps.usercrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dps.usercrud.model.request.UserDetailsRequest;
import com.dps.usercrud.model.response.UserDetailsResponse;
import com.dps.usercrud.service.UserRegistrationService;

import jakarta.validation.Valid;

@RestController
public class UserRegistrationController implements UserRegistrationAPI {

	@Autowired
	private UserRegistrationService userRegistrationService;

	@Override
	public ResponseEntity<List<UserDetailsResponse>> getAllUsers() {
		System.out.println("123");
		List<UserDetailsResponse> allUsers = userRegistrationService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}

	@Override
	public ResponseEntity<Void> saveUser(@Valid UserDetailsRequest userDetailsRequest) {
		userRegistrationService.saveUser(userDetailsRequest);
		return ResponseEntity.ok(null);
	}

	@Override
	public ResponseEntity<List<UserDetailsResponse>> deleteUser(Integer userid) {
		userRegistrationService.deleteUser(userid);
		List<UserDetailsResponse> users = userRegistrationService.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@Override
	public ResponseEntity<Void> updateUser(Integer userid, @Valid UserDetailsRequest userDetailsRequest) {
		userRegistrationService.updateUser(userid, userDetailsRequest);
		return ResponseEntity.ok(null);
	}

	

}
