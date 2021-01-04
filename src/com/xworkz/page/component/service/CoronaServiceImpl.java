package com.xworkz.page.component.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.util.StringUtils;

import com.xworkz.page.component.dao.CoronaDaoImpl;

import com.xworkz.page.component.dto.CoronaPatientDTO;

@Component
public class CoronaServiceImpl implements CorornaService {

	@Autowired
	private CoronaDaoImpl dao;

	public CoronaServiceImpl() {

		System.out.println("created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean validateAndSave(CoronaPatientDTO dto) {
		System.out.println("Invoed validate and save method.");
		boolean valid = false;
		String name = dto.getName();

		if (Objects.nonNull(dto) && name.length() > 2) {
			System.out.println("name is valid");
			valid = true;
		} else {
			System.out.println("Name is invalid");
			valid = false;
		}
		if (valid) {
			String email = dto.getEmail();
			if (!StringUtils.isEmpty(email)) {
				String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
						+ "A-Z]{2,7}$";

				boolean result = email.matches(regex);
				if (result == true) {
					System.out.println("Email is valid");

					valid = true;}
					 else {
							System.out.println("Email is invalid");
							valid = false;

						}
				
			}
			if (valid) {
				long mob = dto.getMobNum();
				if (String.valueOf(mob).length() == 10) {
					System.out.println("mobile number is valid");
					valid = true;

				} else {
					System.out.println("mobile number  is invalid");
					valid = false;

				}

			}
			if (valid) {
				int age = dto.getAge();
				if (age > 0) {
					System.out.println("Age is valid");
					valid = true;

				} else {
					System.out.println("Age is invalid");
					valid = false;

				}

			}
			if (valid) {
				String adress = dto.getAdress();
				if (!StringUtils.isEmpty(adress)) {
					System.out.println("adress is valid");
					valid = true;

				} else {
					System.out.println("Adress is invalid");
					valid = false;

				}

			}

			if (valid) {
				String result = dto.getResult();
				if (!StringUtils.isEmpty(result)) {
					System.out.println("result is valid");
					valid = true;

				} else {
					System.out.println("result is invalid");
					valid = false;

				}

			}
			if (valid) {
				String state = dto.getState();
				if (!StringUtils.isEmpty(state)) {
					System.out.println("state is valid");
					valid = true;

				} else {
					System.out.println("state is invalid");
					valid = false;

				}

			}

		}
		if (valid) {
			System.out.println("data is ready to save to DB");
			long pk = dao.save(dto);
			System.out.println("data is saved with the primary key :" + pk);
		} else {
			System.out.println("data is invalid plz check the data");
		}
		return valid;

	}

}
