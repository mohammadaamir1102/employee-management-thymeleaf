package com.aamir.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.aamir.dto.UserRegistrationDto;
import com.aamir.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
