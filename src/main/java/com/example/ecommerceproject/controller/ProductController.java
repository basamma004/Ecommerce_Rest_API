package com.example.ecommerceproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ecommerceproject.entity.Product;
import com.example.ecommerceproject.repository.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Add a new product with validation
    @PostMapping("/add")
    public Product addProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    // Get all products
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
//post localhost:2027/product/add
//{
//"name": "Laptop",
//"price": 55000,
//"quantity": 5,
//"category": {
//"id": 1
//}
//}

//get localhost:2027/product/all