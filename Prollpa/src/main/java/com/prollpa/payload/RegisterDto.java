package com.prollpa.payload;

import lombok.Data;


public class RegisterDto {
	private long registerId;
	public long getRegisterId() {
		return registerId;
	}
	public void setRegisterId(long registerId) {
		this.registerId = registerId;
	}
	private String username;
	private String password;
	private String emailId;
	private String conformPassword;
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
	public String getEmailId() {
		return emailId;
	}
	public RegisterDto(String username, String password, String emailId, String conformPassword,long registerId) {
		super();
		this.registerId=registerId;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.conformPassword = conformPassword;
	}
	public RegisterDto() {
		super();
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getConformPassword() {
		return conformPassword;
	}
	public void setConformPassword(String conformPassword) {
		this.conformPassword = conformPassword;
	}
}
