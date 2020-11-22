package com.xworkz.Mountain;

import java.lang.reflect.Method;
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
		
		/*Method[] m = i.getClass().getMethods();
		System.out.println(m);
		for (Method method : m) {
			System.out.println(method.getName());
		}*/
		/*Array a=spring.getBean(Array.class);
		Method [] md=a.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*Error er=spring.getBean(Error.class);
		Method [] md=er.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*Exception ex=spring.getBean(Exception.class);
		Method [] md=ex.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*FileHandler fh=spring.getBean(FileHandler.class);
		Method [] md=fh.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*Label l=spring.getBean(Label.class);
		Method [] md=l.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*List li=spring.getBean(List.class);
		Method [] md=li.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*Modifier mf=spring.getBean(Modifier.class);
		Method [] md=mf.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*Object o=spring.getBean(Object.class);
		Method [] md=o.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		Stack s=spring.getBean(Stack.class);
		Method [] md=s.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}
		

	}

}
