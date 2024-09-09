package com.koo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.koo.model.BoardUser;
import com.koo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository ;
	private final PasswordEncoder passwordEncoder;
	
	public BoardUser create(String username, String email, String password) {
		BoardUser user = new BoardUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
		
		return user;
	}
}

