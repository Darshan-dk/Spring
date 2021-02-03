package com.xworkz.commonmodules.service;

import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.exception.ServiceException;

public interface PasswordResetService {

	boolean sendMail(EcommerceDTO dto,String otp) throws ServiceException;
}