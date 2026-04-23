package com.example.ecommerceproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerceproject.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	List<Cart> findByUserId(Long userId);
//    Optional<Cart> findById(Long User);
}