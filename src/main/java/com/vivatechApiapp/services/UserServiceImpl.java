package com.vivatechApiapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vivatechApiapp.entiry.User;
import com.vivatechApiapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User createUser(User user) {

		// Check if username exists in the DB
		if (userRepository.existsByUsername(user.getUsername())) {
			throw new IllegalArgumentException("Username is already taken!");
		}

		// Check if email exists in the DB
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new IllegalArgumentException("Email is already taken!");
		}

		// Encode the user's password before saving to the database
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return userRepository.save(user);
	}

	// Implement other service methods if needed
}
