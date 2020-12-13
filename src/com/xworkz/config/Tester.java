package com.xworkz.config;

import com.xworkz.dao.CoronaVaccineDAO;
import com.xworkz.dto.CoronaVaccineDTO;

public class Tester {
	
	public static void main(String[] args) {
		
		CoronaVaccineDTO dto = new CoronaVaccineDTO();
		dto.setCountry("India");
		dto.setDevelopedBy("russia");
		dto.setName("df");
		
		
		
		dto.setReadyToUse(true);
		
		CoronaVaccineDAO dao = new CoronaVaccineDAO();
		dao.save(dto);
		
		
	}

}
