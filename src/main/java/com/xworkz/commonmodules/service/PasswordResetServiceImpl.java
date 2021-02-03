package com.xworkz.commonmodules.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.exception.ServiceException;

@Component
public class PasswordResetServiceImpl implements PasswordResetService {

	@Autowired
	private MailSender mailsender;
	
	@Override
	public boolean sendMail(EcommerceDTO commerceDTO, String otp) throws ServiceException {
		
		
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(commerceDTO.getEmail());
		mailMessage.setSubject("One Time Password");
		mailMessage.setText("Hello, "+"\n"+commerceDTO.getFirstName()+"\n"+"Please login with "+"\n"+"Email :"+commerceDTO.getEmail()+
				"\n"+"Password: "+otp);
		try{
		mailsender.send(mailMessage);
		return true;
		}catch(MailException e){
			throw new ServiceException(e.getMessage());
		}
	}

	

}
