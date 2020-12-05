package com.xworkz.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("resources/config.xml");
		RocketDTO rocketDTO = container.getBean(RocketDTO.class);
		RocketDAO databaseObject = container.getBean(RocketDAO.class);
//		databaseObject.save(rocketDTO);
		databaseObject.delete(rocketDTO);
//     	databaseObject.update(rocketDTO);
//		databaseObject.fetch();
		
	}
	

}
