package com.example.ecommerceproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerceproject.entity.Cart;
import com.example.ecommerceproject.entity.Order;
import com.example.ecommerceproject.entity.User;
import com.example.ecommerceproject.repository.CartRepository;
import com.example.ecommerceproject.repository.OrderRepository;
import com.example.ecommerceproject.repository.UserRepository;

@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order placeOrder(Long userId) {

        // ✅ 1. Get User
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ 2. Get Cart Items
        List<Cart> cartItems = cartRepository.findByUserId(userId);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        // ✅ 3. Calculate Total
        double total = 0;

        for (Cart cart : cartItems) {
            total += cart.getProduct().getPrice() * cart.getQuantity();
        }

        // ✅ 4. Create Order
        Order order = new Order();
        order.setUser(user);
        order.setCartItems(cartItems);
        order.setTotalAmount(total);

        // ✅ 5. Save Order
        Order savedOrder = orderRepository.save(order);

        // ✅ 6. Clear Cart
//        cartRepository.deleteAll(cartItems);
        for (Cart cart : cartItems) {
            cart.setOrder(savedOrder);   // 🔥 IMPORTANT LINE
            cartRepository.save(cart);
        }
        return savedOrder;
    }
}