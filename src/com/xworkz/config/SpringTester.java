package com.xworkz.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.dao.CoronaVaccineDAO;
import com.xworkz.dto.CoronaVaccineDTO;

public class SpringTester {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("resources/tester.xml")) {

			CoronaVaccineDAO vaccineDAO = container.getBean(CoronaVaccineDAO.class);

			CoronaVaccineDTO dto = new CoronaVaccineDTO();
			dto.setCountry("China");
			dto.setDevelopedBy("russia");
			dto.setName("abcd");
			dto.setReadyToUse(true);

//			vaccineDAO.save(dto);
//			vaccineDAO.update(5, "xyz");
//			vaccineDAO.fetch(5);
			vaccineDAO.delete(7);

		}

	}

}
