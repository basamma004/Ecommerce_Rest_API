package com.example.ecommerceproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerceproject.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional <User> findByEmail(String email);

	Optional<User> findById(Long userId);
	
	
}