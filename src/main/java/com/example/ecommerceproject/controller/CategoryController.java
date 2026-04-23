package com.example.ecommerceproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceproject.entity.Category;
import com.example.ecommerceproject.repository.CategoryRepository;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
// post localhost:2027/category/add  
//{
//"name": "Electronics"
//}

//get  localhost:2027/category/all