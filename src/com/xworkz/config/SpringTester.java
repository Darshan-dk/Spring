package com.xworkz.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.dao.CoronaVaccineDAO;
import com.xworkz.dto.CoronaVaccineDTO;

public class SpringTester {
	
	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("resources/tester.xml");
		CoronaVaccineDAO vaccineDAO = container.getBean(CoronaVaccineDAO.class);

		CoronaVaccineDTO dto = new CoronaVaccineDTO();
		dto.setCountry("India");
		dto.setDevelopedBy("russia");
		dto.setName("df");
		
	vaccineDAO.save(dto);
		
		
		
	}

}
