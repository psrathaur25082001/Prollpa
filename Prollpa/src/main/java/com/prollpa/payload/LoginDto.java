package com.prollpa.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class LoginDto {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public LoginDto() {
		
	}

}
