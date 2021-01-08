package com.xworkz.commonmodule.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="Ecomerce_data")
public class EcommerceDTO implements Serializable {
	
	@Id
	@GenericGenerator(name= "ref", strategy="increment")
	@GeneratedValue(generator = "ref")
	private int id;
	private String firstName;
	private String secondName;
	private String email;
	private String password;
	private String repassword;
	
	public EcommerceDTO() {
		// TODO Auto-generated constructor stub
		System.out.println("Invoked "+this.getClass().getSimpleName());
	}


}
