package com.xworkz.arraylist;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	
	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("resources/registration.xml");
		Colllection ArrayList = container.getBean("arrayLIst",Colllection.class);
		ArrayList<String> cars = ArrayList.getCars();
		System.out.println(cars);
		Colllection treeSet = container.getBean("treeSet",Colllection.class);
		
		
	}

}
