package com.prollpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="t_user_mas")
public class User {
	@Id
	private long userId;
	private String username;
	private String email;
	private String name;
	

}
