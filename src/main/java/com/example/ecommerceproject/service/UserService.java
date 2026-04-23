package com.example.ecommerceproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerceproject.dto.RequestLogin;
import com.example.ecommerceproject.dto.ResponseLogin;
import com.example.ecommerceproject.entity.User;
import com.example.ecommerceproject.repository.UserRepository;
import com.example.ecommerceproject.security.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder; // ✅ ADD THIS

    // ✅ REGISTER (with BCrypt)
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // 🔐 encrypt password
        return userRepository.save(user);
    }

    // ✅ LOGIN (with BCrypt + JWT)
    public ResponseLogin login(RequestLogin requestLogin) {

        if (requestLogin.getEmail() == null || requestLogin.getEmail().isEmpty()) {
            return new ResponseLogin("Email is Mandatory", false);
        }

        if (requestLogin.getPassword() == null || requestLogin.getPassword().isEmpty()) {
            return new ResponseLogin("Password is Mandatory", false);
        }

        Optional<User> user = userRepository.findByEmail(requestLogin.getEmail());

        if (user.isPresent()) {

            // 🔥 IMPORTANT: use matches() NOT equals()
            if (passwordEncoder.matches(requestLogin.getPassword(), user.get().getPassword())) {

                // ✅ Generate JWT token
                String token = jwtUtil.generateToken(user.get().getEmail());

                return new ResponseLogin(token, true);

            } else {
                return new ResponseLogin("Invalid password", false);
            }

        } else {
            return new ResponseLogin("User not found", false);
        }
    }
}