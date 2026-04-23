package com.example.ecommerceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecommerceproject.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}