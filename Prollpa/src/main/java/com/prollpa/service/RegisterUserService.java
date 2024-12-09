package com.prollpa.service;

import com.prollpa.payload.RegisterDto;

public interface RegisterUserService {
	RegisterDto saveUser(RegisterDto user);
	boolean findByUsernameAndPassword(String username,String password);
	

}
