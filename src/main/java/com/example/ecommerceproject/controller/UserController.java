package com.example.ecommerceproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceproject.dto.RequestLogin;
import com.example.ecommerceproject.dto.ResponseLogin;
import com.example.ecommerceproject.entity.User;
import com.example.ecommerceproject.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    // Register user
    @PostMapping("/register")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        service.register(user); // Saves user to DB
        return ResponseEntity.ok("User created successfully");
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<ResponseLogin> login(@RequestBody RequestLogin requestLogin) {
        ResponseLogin response = service.login(requestLogin);
        return ResponseEntity.ok(response);
    }
}

//post localhost:2027/users/register
//{
//	  "name": "Rahul",
//	  "email": "rahul@gmail.com",
//	  "password": "12345"
//	}

//post localhost:2027/users/login
//{
//	  "email": "rahul@gmail.com",
//	  "password": "12345"
//	}