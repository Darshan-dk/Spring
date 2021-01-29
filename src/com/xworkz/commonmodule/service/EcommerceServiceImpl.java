package com.xworkz.commonmodule.service;

import java.sql.PreparedStatement;
import java.util.Objects;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.xworkz.commonmodule.dao.EcomerceDAO;
import com.xworkz.commonmodule.dto.EcommerceDTO;
import com.xworkz.commonmodule.exception.RepositoryException;

@Component
public class EcommerceServiceImpl implements EcommerceService {

	@Autowired
	private EcomerceDAO dao;

	public EcommerceServiceImpl() {

		System.out.println("created " + this.getClass().getSimpleName());
	}

	@Override
	public String validateAndSave(EcommerceDTO dto) throws ServiceException {
		boolean valid = false;
		String message="NA";
		
		
		if (Objects.nonNull(dto)) {
			String fName = dto.getFirstName();
			if (!fName.isEmpty() && fName.length() >= 3) {
				valid = true;
				
				System.out.println("Name is valid");
			} else {
				valid = false;
				System.out.println("Name is invalid");
			}
			if (valid) {
				if (Objects.nonNull(dto)) {
					String sName = dto.getSecondName();
					if (!sName.isEmpty() && sName.length() >= 3) {
						valid = true;
						
						System.out.println("last name  is valid");
					} else {
						valid = false;
						System.out.println("last name is invalid");
					}
			}
			}
			if (valid) {
				String pass = dto.getPassword();
				String cPass = dto.getPassword();
				if (pass.equals(cPass)) {
					valid = true;
					System.out.println("Passwords matching");
				} else {
					valid = false;
					System.out.println("Pasword is not matching");
				}
			}
			if (valid) {
				String email = dto.getEmail();
				
				String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
				if (email.matches(regex)) {
					valid = true;
					System.out.println("Email is valid");
				} else {
					valid = false;
					System.out.println("Email is invalid");
				}
			}
			if (valid) {
				
				try {
					if(dao.fetchEmailCount(dto)>0){
						message="duplicate";
					}else{
					dao.save(dto);
					System.out.println("Inputs are valid and saving");
					message="saved";
					}
				} catch (RepositoryException e) {
					
					throw new ServiceException(e.getMessage());
				}catch (Exception e) {
					throw new ServiceException(e.getMessage());
				}
				
			} else {
				System.out.println("Inputs are invalid and not saving");
			}

		} else {
			System.out.println("No Inputs");
		}

		return message;
	}
}
