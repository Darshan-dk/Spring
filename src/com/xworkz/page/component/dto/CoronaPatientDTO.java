package com.xworkz.page.component.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
@Table(name="corona_Patient_details")
public class CoronaPatientDTO {
	
	@Id
	@GenericGenerator(name= "ref", strategy="increment")
	@GeneratedValue(generator = "ref")
	private long id;
	private String name;
	private int age;
	private long mobNum;
	private String email;
	private String adress;
	private String result;
	private String state;
	
	
	public CoronaPatientDTO() {
		// TODO Auto-generated constructor stub
		System.out.println("invoked CoronaPatient dto"); 
	}

}
