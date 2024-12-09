package com.prollpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="t_register_user")
public class RegisterUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long registerId;
	private String username;
	private String password;
	private String emailId;
	private String conformPassword;
	public RegisterUser() {
		
	}
	public RegisterUser(long registerId, String username, String password, String emailId, String conformPassword) {
		super();
		this.registerId = registerId;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.conformPassword = conformPassword;
	}
	public long getRegisterId() {
		return registerId;
	}
	public void setRegisterId(long registerId) {
		this.registerId = registerId;
	}
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
