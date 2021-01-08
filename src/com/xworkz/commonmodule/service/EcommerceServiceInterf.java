package com.xworkz.commonmodule.service;

import java.util.Objects;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.xworkz.commonmodule.dao.EcomerceDAO;
import com.xworkz.commonmodule.dto.EcommerceDTO;

@Component
public class EcommerceServiceInterf implements EcommerceService {

	@Autowired
	private EcomerceDAO dao;

	public EcommerceServiceInterf() {

		System.out.println("created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean validateAndSave(EcommerceDTO dto) throws ServiceException{

		boolean valid;
		System.out.println("Invoked validate and save method.");
		valid = false;
		try {

			String fname = dto.getFirstName();

			if (Objects.nonNull(dto) && fname.length() > 2) {
				System.out.println("First name is valid");
				valid = true;
			} else {
				System.out.println(" First name is invalid");
				valid = false;
			}
			if (valid) {
				String lname = dto.getFirstName();

				if (Objects.nonNull(dto) && lname.length() > 2) {
					System.out.println("Last name is valid");
					valid = true;
				} else {
					System.out.println(" Last name is invalid");
					valid = false;

				}
				}
				if (valid) {
					String email = dto.getEmail();
					if (!StringUtils.isEmpty(email)) {
						String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
								+ "A-Z]{2,7}$";

						boolean result = email.matches(regex);
						System.out.println("Email is valid");

						valid = true;
					} else {
						System.out.println("Email is invalid");
						valid = false;

					}

				}

				if (valid) {
					String pwd = dto.getPassword();
					if (pwd.length() > 4) {
						System.out.println("Password is valid");
						valid = true;

					} else {
						System.out.println("Password is invalid");
						valid = false;

					}

				}
				if (valid) {
					String pwd = dto.getPassword();
					String rpwd = dto.getRepassword();
					if (pwd.equals(rpwd)) {
						System.out.println("Password is valid");
						valid = true;

					} else {
						System.out.println("Password is invalid");
						valid = false;

					}

				}

				if (valid) {
					System.out.println("data is ready to save to DB");
					dao.save(dto);
				}
			else {
				System.out.println("data is invalid plz check the data");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Repository exception in service");
		} catch (Exception e) {
			throw new ServiceException("Repository exception in service");
		}
		return valid;

	}

}
