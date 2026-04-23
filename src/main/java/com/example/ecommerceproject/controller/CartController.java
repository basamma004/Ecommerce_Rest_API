package com.example.ecommerceproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceproject.entity.Cart;
import com.example.ecommerceproject.repository.CartRepository;
import com.example.ecommerceproject.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    // ✅ THIS MAKES /cart/add WORK
    @PostMapping("/add")
    public String addToCart(@RequestParam Long userId,
                           @RequestParam Long productId,
                           @RequestParam Integer quantity) {

        cartService.addToCart(userId, productId, quantity);
        return "Added to Cart";
    }

    // ✅ View Cart
    @GetMapping("/user/{userId}")
    public List<Cart> getCart(@PathVariable Long userId) {
        return cartRepository.findByUserId(userId);
    }

   }
// post localhost:2027/cart/add?userId=1&productId=1&quantity=2
// get localhost:2027/cart/user/1