package com.xworkz.config.service;

import com.xworkz.config.dao.CoronaVaccineDAO;
import com.xworkz.config.dto.CoronaVaccineDTO;

public class CoronaVaccineService {

	private CoronaVaccineDAO dao;

	public CoronaVaccineService(CoronaVaccineDAO dao) {
		System.out.println("Created " + this.getClass().getSimpleName());
		this.dao = dao;
	}

//	public String validateAndUpdateById(long vaccineId ,String name) {
//
//		System.out.println("validateAndSave method is invoked");
//		String message = "NA";
//		boolean valid = false;
//		
//
//			if (name != null && !name.isEmpty()) {
//				System.out.println("Name is valid");
//				valid = true;
//			} else {
//				System.out.println("Name is not vaid");
//				valid = false;
//			}
//
//			if (valid) {
//				System.out.println("Saving the dto");
//				dao.save(dto);
//				message = "SUCCESS";
//			}
//			
//
//		} else
//			System.out.println("dto is null,cannot save");
//		return message;
//
//	}
	public String validateAndSave(CoronaVaccineDTO dto) {

		System.out.println("validateAndSave method is invoked");
		String message = "NA";
		boolean valid = false;
		
		if (dto != null) {
			System.out.println("dto is an object");
			String name = dto.getName();
			String developedBy = dto.getDevelopedBy();
			long id = dto.getVaccineId();
			String country = dto.getCountry();

			if (name != null && !name.isEmpty()) {
				System.out.println("Name is valid");
				valid = true;
			} else {
				System.out.println("Name is not valid");
				valid = false;
				
			}if (developedBy != null && !developedBy.isEmpty()) {
				System.out.println("developedBy is valid");
				valid = true;
			} else {
				System.out.println("developedBy is not valid");
				valid = false;
				
			}if (id >=0 ) {
				System.out.println("id is valid");
				valid = true;
			} else {
				System.out.println("id is not valid");
				valid = false;
			}
			if (country != null && !country.isEmpty()) {
				System.out.println("country is valid");
				valid = true;
			} else {
				System.out.println("country is not  valid");
				valid = false;
			}

			if (valid) {
				System.out.println("Saving the dto");
				dao.save(dto);
				message = "SUCCESS";
			}else {
				System.out.println("Saving the dto is Failed");
				dao.save(dto);
				message = "FAILED";
			}
				

		} else
			System.out.println("dto is null,cannot save");
		return message;

	}


}
