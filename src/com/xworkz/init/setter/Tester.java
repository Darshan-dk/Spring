package com.xworkz.init.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
	public static void main(String[] args) {
		
		String configFileName = "resources/setterMethod.xml";
		ApplicationContext spring = new ClassPathXmlApplicationContext(configFileName);
		Hotel bean = spring.getBean("hotelType",Hotel.class);
		bean.getType(false);
	}

}


/*public class Hotel {			
	
	private String name;// init using const		
	private boolean type;// init using set		
	private String location;/init using set		
			
	}	*/	