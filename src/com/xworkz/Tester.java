package com.xworkz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
	
	public static void main(String[] args) {
		
		String confiFile = "resources/counstructor.xml";
		ApplicationContext spring = new ClassPathXmlApplicationContext(confiFile);
		Season refOfFestival=spring.getBean("season" ,Season.class);		
		Season twoParameter=spring.getBean("twoConstruct" ,Season.class);
		Season twoParameterOverLoad=spring.getBean("twoConstructDiffArg" ,Season.class);
		Season oneParameter2=spring.getBean("temp" ,Season.class);		
		Season oneParameter3=spring.getBean("noOfDays" ,Season.class);
		Season fourParameter=spring.getBean("fourParameter" ,Season.class);


	}

}
