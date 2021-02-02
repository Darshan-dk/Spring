package com.xworkz.commonmodules.service;

import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.exception.ServiceException;

public interface EcommerceService {
	
	public String validateAndSave(EcommerceDTO dto) throws ServiceException;

}
