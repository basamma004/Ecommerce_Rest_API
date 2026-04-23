package com.example.ecommerceproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerceproject.entity.Product;
import com.example.ecommerceproject.repository.ProductRepository;

@Service
public class ProductService {
 private ProductRepository repo;
 
 public ProductService(ProductRepository repo)
 {
	 this.repo = repo;
 }
 public Product save(Product product) {
	 return repo.save(product);
 }
 public List<Product> getAll()
 {
	 return repo.findAll();
 }
}