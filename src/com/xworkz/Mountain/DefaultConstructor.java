package com.xworkz.Mountain;

import java.sql.Time;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Stack;
import java.util.concurrent.Phaser;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.xalan.internal.xslt.Process;

import javafx.scene.transform.Scale;
import sun.util.resources.CalendarData;

public class DefaultConstructor {
	
	public static void main(String[] args) {
		System.out.println("Starting the spring frameWork");
		
		String configFileName = "resources/classes.xml";
		
		ApplicationContext spring = new ClassPathXmlApplicationContext(configFileName);
		
		String string = spring.getBean(String.class);
		Exception exc = spring.getBean(Exception.class);
		Thread tread = spring.getBean(Thread.class);
		StringBuffer stringBuffer = spring.getBean(StringBuffer.class);
		StringBuilder stringBuilder = spring.getBean(StringBuilder.class);
		Error error = spring.getBean(Error.class);
		CalendarData calendarData = spring.getBean(CalendarData.class);
		Scale scale = spring.getBean(Scale.class);
		Date date = spring.getBean(Date.class);
		Phaser phaser = spring.getBean(Phaser.class);
		

			}

}
