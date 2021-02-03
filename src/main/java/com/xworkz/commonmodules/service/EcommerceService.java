package com.xworkz.commonmodules.service;

import java.util.List;

import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.dto.LoginDTO;
import com.xworkz.commonmodules.dto.ResetDTO;
import com.xworkz.commonmodules.exception.RepositoryException;
import com.xworkz.commonmodules.exception.ServiceException;

public interface EcommerceService {
	
String validateAndSave (EcommerceDTO commerceDTO)throws ServiceException;
	
public String validateAndLogin(EcommerceDTO dto,LoginDTO loginDTO) throws ServiceException;
	
	boolean isValidUser(EcommerceDTO dto) throws ServiceException;

	boolean resetPassword(EcommerceDTO dto) throws ServiceException;

	String validateAndUpdatePassword( ResetDTO resetDTO) throws ServiceException;

	List<EcommerceDTO> loginDetails(EcommerceDTO dto) throws RepositoryException;
	
	boolean sendMail(EcommerceDTO commerceDTO)throws ServiceException;
}
