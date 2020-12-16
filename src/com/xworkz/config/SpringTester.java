package com.xworkz.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.config.dao.CoronaVaccineDAO;
import com.xworkz.config.dto.CoronaVaccineDTO;
import com.xworkz.config.service.CoronaVaccineService;

public class SpringTester {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("resources/tester.xml")) {

			CoronaVaccineService vaccineDAO = container.getBean(CoronaVaccineService.class);

			CoronaVaccineDTO dto = new CoronaVaccineDTO();
			dto.setCountry("China");
			dto.setDevelopedBy(null);
			dto.setName("abcd");
			dto.setReadyToUse(true);

		vaccineDAO.validateAndSave(dto);
//			vaccineDAO.update(5, "xyz");
//			vaccineDAO.fetch(5);
			//vaccineDAO.deleteById(2);

		}

	}

}
