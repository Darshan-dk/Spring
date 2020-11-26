package com.xworkz;

public class Season {
	
	private String name;
	private float temp;
	private int noOfMonths;
	private String sunLight;
	
	public Season(String name, float temp, int noOfMonths, String sunLight) {
		super();
		this.name = name;
		this.temp = temp;
		this.noOfMonths = noOfMonths;
		this.sunLight = sunLight;
		System.out.println(this.getClass().getSimpleName()+ " created with four parameter");
	}
	
	public Season(String name, float temp) {
		super();
		this.name=name;
		this.temp=temp;
		System.out.println(this.getClass().getSimpleName()+" created with name and temp sig");
		
		}
	public Season(float temp,String name) {
		super();
		this.name=name;
		this.temp=temp;
		System.out.println(this.getClass().getSimpleName()+" created with two argument temp and name ");
		
		}
	public Season(String name) {
		super();
		this.name =name;
		System.out.println(this.getClass().getSimpleName()+" created with single string arg");
	}
	public Season(float temp) {
		super();
		this.temp =temp;
		System.out.println(this.getClass().getSimpleName()+" created with single float arg");
	}
	public Season(int noOfMonths) {
		super();
		this.noOfMonths =noOfMonths;
		System.out.println(this.getClass().getSimpleName()+" created with single int arg");
	}
	
	public void display() {
		System.out.println("display method is invoked");
	}
	
	
}
/*Write Season program done in class 

Write a class with a constructor of four parameters and create a bean 

Write a Class with a constructor of two parameters over-loaded create two beans

Write a class with a constructor of one parameter create three beans 
*/