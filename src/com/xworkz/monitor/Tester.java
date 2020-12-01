package com.xworkz.monitor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
	public static void main(String[] args) {
		String configFile = "resources/monitor.xml";
		ApplicationContext spring = new ClassPathXmlApplicationContext(configFile);
//		MonitorFactory setter = spring.getBean("setter",MonitorFactory.class);
//		MonitorFactory setterMfgDate = spring.getBean("setterMfgDate",MonitorFactory.class);

	
	}

}
