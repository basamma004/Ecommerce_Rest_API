package com.example.ecommerceproject.dto;

public class ResponseLogin {

    private String message; // token or error message
    private boolean status;

    public ResponseLogin(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }
}