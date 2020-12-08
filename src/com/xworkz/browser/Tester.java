package com.xworkz.browser;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("resources/tester.xml")){
			Power power = container.getBean(Power.class);
			
			Internet internet = container.getBean(Internet.class);
			internet.connect();
			
			Browser browser = container.getBean(Browser.class);
			browser.connect();
			
		}
		
	}
}
