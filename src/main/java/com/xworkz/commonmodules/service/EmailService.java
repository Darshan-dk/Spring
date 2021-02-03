package com.xworkz.commonmodules.service;

import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.exception.ServiceException;

public interface EmailService {

	boolean sendMail(EcommerceDTO commerceDTO)throws ServiceException;
}
