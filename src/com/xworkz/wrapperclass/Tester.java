package com.xworkz.wrapperclass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
	public static void main(String[] args) {

		String configFileName = "resources/wraperClasses.xml";
		ApplicationContext spring = new ClassPathXmlApplicationContext(configFileName);
		String string = spring.getBean(String.class);
		System.out.println(string);
		Integer integer = spring.getBean(Integer.class);
		System.out.println(integer);
		Byte byte1 = spring.getBean(Byte.class);
		System.out.println(byte1);
		Short short1 = spring.getBean(Short.class);
		System.out.println(short1);
		Character char1 = spring.getBean(Character.class);
		System.out.println(char1);
		Boolean bool = spring.getBean(Boolean.class);
		System.out.println(bool);
		Double dbl = spring.getBean(Double.class);
		System.out.println(dbl);
		Float ft = spring.getBean(Float.class);
		System.out.println(ft);
		Long lg = spring.getBean(Long.class);
		System.out.println(lg);
		
	}	
}
