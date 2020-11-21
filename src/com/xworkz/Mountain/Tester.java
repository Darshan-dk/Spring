package com.xworkz.Mountain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
	public static void main(String[] args) {
//		Virus virus = new Virus();
//		virus.getInfected();
		
		System.out.println("Starting the spring engine");
		String configFileName = "resources/spring.xml";
		ApplicationContext spring = new ClassPathXmlApplicationContext(configFileName);
		Virus refOfVirus=spring.getBean(Virus.class);
		refOfVirus.getInfected();
		String string = spring.getBean(String.class);
		
		

	}

}
