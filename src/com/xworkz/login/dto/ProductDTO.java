package com.xworkz.login.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ProductDTO {
	
	private String name;
	private double price;
	private int quntity;
	private String brand;
	
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
		System.out.println("invoked product dto"); 
	}

}
