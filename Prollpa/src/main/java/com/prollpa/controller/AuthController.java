package com.prollpa.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prollpa.payload.LoginDto;
import com.prollpa.payload.RegisterDto;
import com.prollpa.payload.UserDto;
import com.prollpa.service.RegisterUserService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping
@Tag(name = "Auth Controller Api", description = "Authentication Management")
public class AuthController {
	@Autowired
	private RegisterUserService registerUserService;
	@Autowired
	private AuthenticationManager authenticationManager;
//	@PostMapping("/register")
//	public ResponseEntity<String> saveUser(@RequestBody RegisterDto user){
//		RegisterDto saveUser = registerUserService.saveUser(user);
//		if(saveUser!=null) {
//			return ResponseEntity.status(HttpStatus.CREATED).body("user Register successfully");
//		}else {
//			return ResponseEntity.status(HttpStatus.CREATED).body("user not Registered");
//		}
//	}
//	@PostMapping("/login")
//	public ResponseEntity<String> loginByUserNameAndPassword(@RequestBody LoginDto dto ){
//		boolean loginCheck=registerUserService.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
//		if(loginCheck) {
//			return ResponseEntity.status(HttpStatus.OK).body("user Login successfully");
//		}else {
//			return ResponseEntity.status(HttpStatus.OK).body("please enter the valid username and password");
//		}
//	}
	
	
	
	 @PostMapping("/authldap")
	 @Operation(summary = "login", description = "check the username and password is correct or not")
	 public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
		 try {
		 Authentication authentication = authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
         );
		 return ResponseEntity.status(HttpStatus.OK).body("Authentication Successfull");
		 }catch(AuthenticationException e){
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("please enter the valid credentials"+e);
		 }
	 }
	 @GetMapping("/test1")
	 public ResponseEntity<String> testApi(){
		 return ResponseEntity.ok("service one working fine ");
	 }


}
