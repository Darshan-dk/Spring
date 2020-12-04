package com.xworkz.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("resources/config.xml");
		DatabaseObject databaseObject = container.getBean(DatabaseObject.class);
		databaseObject.save(3);
//		databaseObject.delete();
//		databaseObject.update();
//		databaseObject.fetch();
		
	}
	

}
