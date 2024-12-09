package com.prollpa.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prollpa.entity.RegisterUser;

public interface RegisterUserRepository extends JpaRepository<RegisterUser,Long>{
	Optional<RegisterUser> findByUsernameAndPassword(String username, String password);
}
