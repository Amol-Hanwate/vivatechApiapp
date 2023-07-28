package com.vivatechApiapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivatechApiapp.entiry.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email); 
	Optional<User> findByUsernameOrEmail(String username, String email); 
	Optional<User> findByUsername(String username); 
	Boolean existsByUsername(String username); 
	Boolean existsByEmail(String email); 
}
