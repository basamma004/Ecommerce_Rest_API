package com.example.ecommerceproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "1.0", message = "Price must be greater than 0")
    private Double price;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    @NotNull(message = "Category is required")
    @Valid
    private Category category;

    // Getters & Setters
    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) {
    	this.id = id;
    }

    public String getName() {
    	return name;
    }
    public void setName(String name) { 
    	this.name = name; 
    }

    public Double getPrice() {
    	return price; 
    }
    public void setPrice(Double price) { 
    	this.price = price; 
    }

    public Integer getQuantity() { 
    	return quantity; 
    }
    public void setQuantity(Integer quantity) { 
    	this.quantity = quantity; 
    }

    public Category getCategory() { 
    	return category; 
    }
    public void setCategory(Category category) { 
    	this.category = category;
    }
}