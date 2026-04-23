package com.example.ecommerceproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerceproject.entity.Category;
import com.example.ecommerceproject.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private  CategoryRepository categoryRepository;
	public Category addCategory(Category category)
	{
		return categoryRepository.save(category);
	}
}