package com.xworkz.commonmodules.service;

import java.util.List;

import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.dto.LoginDTO;
import com.xworkz.commonmodules.dto.ResetDTO;
import com.xworkz.commonmodules.exception.RepositoryException;
import com.xworkz.commonmodules.exception.ServiceException;

public interface EcommerceService {

	String validateAndSave(EcommerceDTO commerceDTO) throws ServiceException;

	public String validateAndLogin(EcommerceDTO dto, LoginDTO loginDTO) throws ServiceException;

	boolean isValidUser(EcommerceDTO dto) throws ServiceException;

	public boolean resetPassword(EcommerceDTO dto, LoginDTO loginDTO)
			throws ServiceException, com.xworkz.commonmodules.exception.ServiceException;

	String validateAndUpdatePassword(ResetDTO resetDTO) throws ServiceException;

	public void updateNameByEmail(String email, String fName, String lName) throws ServiceException;

	List<EcommerceDTO> loginDetails(EcommerceDTO dto) throws RepositoryException;

	boolean sendMail(EcommerceDTO commerceDTO) throws ServiceException;
	public List<EcommerceDTO> loginDetails(String email) throws ServiceException;
}
