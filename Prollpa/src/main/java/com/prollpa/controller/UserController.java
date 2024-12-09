package com.prollpa.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prollpa.helperclass.UserRoleResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller Api", description = "Users Management")
public class UserController {
	
	@PostMapping("/findUserRoleByUserNameAndVSCID")
	@Operation(summary = "findUserRoleByUserNameAndVSCID", description = "This Api will find the User Role for Perticular VSC")
	public ResponseEntity<UserRoleResponse> findUserRoleByUserNameAndVSCID(@PathVariable("userName")String userName){
		UserRoleResponse userRoleResponse=new UserRoleResponse();
		return ResponseEntity.ok(userRoleResponse);
	}

}
