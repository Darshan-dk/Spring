package com.xworkz.commonmodule.service;

import com.xworkz.commonmodule.dto.EcommerceDTO;
import com.xworkz.commonmodule.exception.ServiceException;

public interface EcommerceService {
	
	public String validateAndSave(EcommerceDTO dto) throws ServiceException;

}
