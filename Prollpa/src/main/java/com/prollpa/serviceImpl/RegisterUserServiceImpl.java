package com.prollpa.serviceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prollpa.entity.RegisterUser;
import com.prollpa.payload.RegisterDto;
import com.prollpa.repository.RegisterUserRepository;
import com.prollpa.service.RegisterUserService;

@Service
public class RegisterUserServiceImpl implements RegisterUserService{
	@Autowired
	private RegisterUserRepository registerUserRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public RegisterDto saveUser(RegisterDto user) {
		RegisterUser register = modelMapper.map(user, RegisterUser.class);
		System.out.println(register.getRegisterId());
		RegisterUser save = registerUserRepository.save(register);
		return modelMapper.map(save, RegisterDto.class);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		Optional<RegisterUser> user = registerUserRepository.findByUsernameAndPassword(username, password);
		return user.isPresent();
		
	}

}
