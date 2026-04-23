package com.example.ecommerceproject.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity      //it convert a java class to db table
@Data        // generate getters and setters (lombock)
@NoArgsConstructor   // to generates a constructor with no parameters, used like hibernate,springframework 
@AllArgsConstructor    // to generates a constructor with  parameters for all fields, used to quick create fully initilized obj's
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
   @NotBlank(message = "Name is required")
	private String name;
	
	@OneToMany (mappedBy = "category")
	@JsonManagedReference
	private List<Product> products;

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	   
}

//@NoArgsConstructor  to generates a constructor with no parameters, allows creating an obj 1st and settng values later(via setters)

//@AllArgsConstructor  to generates a constructor with  parameters for all fields, y-> qiuck obj creation with all values initilized,get cleaner and shorter code