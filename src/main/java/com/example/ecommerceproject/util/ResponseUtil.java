package com.example.ecommerceproject.util;

import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity<?> success(Object data) {
        return ResponseEntity.ok(data);
    }

    public static ResponseEntity<?> failure(String message) {
        return ResponseEntity.badRequest().body(message);
    }
}