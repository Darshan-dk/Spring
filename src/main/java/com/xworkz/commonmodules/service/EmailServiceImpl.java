package com.xworkz.commonmodules.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.exception.ServiceException;


public class EmailServiceImpl {
static Logger logger=Logger.getLogger(EmailServiceImpl.class);
	
	@Autowired
	private JavaMailSender mailSender;

	public boolean sendMail(EcommerceDTO commerceDTO) throws ServiceException {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(commerceDTO.getEmail());
		mailMessage.setSubject("Xworkz common module registration");
		mailMessage.setText("Hi " + commerceDTO.getFirstName() + "\n" + "\n"
				+ " your registraion is successful please login with username and password" + "\n" + "\n" + "\n"
				+ "Thanks," + "\n" + "X-workz");

		try {
			mailSender.send(mailMessage);
			return true;
		} catch (MailException e) {
			logger.error(e.getMessage());

			// throw new ServiceException(e.getMessage());

		}

		return false;

	}


}
