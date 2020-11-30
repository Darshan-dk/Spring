package com.xworkz.mobile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Invoking the Tester");
		
		
		String configFileName = "resources/mobile.xml";
		ApplicationContext spring = new ClassPathXmlApplicationContext(configFileName);
		
		MobileFactory mobileFactory = spring.getBean("mobileType",MobileFactory.class);
		System.out.println(mobileFactory.isLteSupported());
		
		
		System.out.println("Tester is Terminated");
	}
}
