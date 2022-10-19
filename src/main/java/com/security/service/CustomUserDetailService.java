package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.model.CustomUserDetails;
import com.security.model.User;
import com.security.repository.UsersRepository;
@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional=usersRepository.findByName(username);
		return new CustomUserDetails(userOptional.get());
	}

}
