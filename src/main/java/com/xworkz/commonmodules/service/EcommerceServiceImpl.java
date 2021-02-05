package com.xworkz.commonmodules.service;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.xworkz.commonmodules.dao.EcomerceDAO;
import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.dto.LoginDTO;
import com.xworkz.commonmodules.dto.ResetDTO;
import com.xworkz.commonmodules.exception.RepositoryException;

@Component
public class EcommerceServiceImpl implements EcommerceService {

	static Logger logger = Logger.getLogger(EcommerceServiceImpl.class);

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private EcomerceDAO dao;
	
	@Autowired
	private PasswordResetService passwordResetService;

	public EcommerceServiceImpl() {

		System.out.println("created " + this.getClass().getSimpleName());
	}

	@Override
	public String validateAndSave(EcommerceDTO dto) throws ServiceException {
		boolean valid = false;
		String message = "NA";

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
					if (dao.fetchEmailCount(dto) > 0) {
						message = "duplicate";
					} else {
						dao.save(dto);
						System.out.println("Inputs are valid and saving");
						message = "saved";
					}
				} catch (RepositoryException e) {

					throw new ServiceException(e.getMessage());
				} catch (Exception e) {
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

	@Override
	public List<EcommerceDTO> loginDetails(EcommerceDTO dto) throws RepositoryException{
		List<EcommerceDTO> list=dao.fetchRow(dto);
		return list;
		
		
	}

	public String validateAndLogin(EcommerceDTO dto,LoginDTO loginDTO) throws ServiceException {
		String message=null;
		boolean accountLocked=false;
		int failedLogin=0;
		try {
			List<EcommerceDTO> list = dao.fetchRow(dto);
			
			
			for (EcommerceDTO eCommerceDTO : list) {
			accountLocked=eCommerceDTO.isAccountStatusLocked();
			
			logger.info("Account locked "+accountLocked);
			
			if(accountLocked==false){
					if (list.size() == 1) {

						logger.info(eCommerceDTO.getFirstName());
						logger.info(list.size());

						if (eCommerceDTO.getPassword().equals(loginDTO.getPassword())) {
							logger.info("password matching");
							dao.updateLoginFailCountToZero(loginDTO.getEmail());
							logger.info("update login count to zero method");
							message = "matching";
						}

						else {
							failedLogin= eCommerceDTO.getInvalidLoginCount();
							
							if (failedLogin < 3){
								dao.updateLoginFailCount(loginDTO);
								message="notMatching";
								logger.info("password not matching");
							}
							
							else{
								dao.updateAccountLocked(loginDTO);
								message = "trialsExceeded";
								logger.info("trials exceeded");
							}
							
							logger.info(eCommerceDTO);
							}
						
					}else {

						logger.info("User not registered");
						message = "notRegistered";
							}
				} if(accountLocked==true) {

					logger.info("Account Locked");
					message = "locked";
						}

			}
			

		} catch (RepositoryException e) {

			throw new ServiceException(e.getMessage());
		}
		return message;

	}

	@Override
	public boolean isValidUser(EcommerceDTO dto) throws ServiceException {

		try {
			boolean validUser = dao.isValidUser(dto);
			if (validUser)
				return true;
		} catch (RepositoryException e) {

			throw new ServiceException(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean resetPassword(EcommerceDTO dto, LoginDTO loginDTO) throws ServiceException, com.xworkz.commonmodules.exception.ServiceException {
		logger.debug("Invoked reset password method");
		try {
			long count = dao.fetchEmailCount(dto);
			logger.debug(count);
			if (count == 1) {
				String oTP = dao.updatePassword(dto);
				List<EcommerceDTO>list= dao.fetchRow(dto);
				for (EcommerceDTO eCommerceDTO : list) {
					boolean sent = passwordResetService.sendMail(eCommerceDTO, oTP);
					logger.debug("Email sent " + sent);
				}
				
				dao.accountUnlocking(loginDTO.getEmail());

				return true;
			}
		} catch (RepositoryException e) {
			throw new ServiceException(e.getMessage());
		}
		return false;

	}

	@Override
	public String validateAndUpdatePassword( ResetDTO resetDTO) throws ServiceException {

		logger.debug("invoked validateAndUpdatePassword");
		String message = "NA";
		boolean valid = false;
		try {
			if (!resetDTO.getPassword().isEmpty() && !resetDTO.getNewPassword().isEmpty()
					&& !resetDTO.getCPassword().isEmpty()) {
				valid = true;
			}
			if (valid) {
				if (resetDTO.getNewPassword().equals( resetDTO.getCPassword())) {

					boolean validOtp = dao.isValidOtp(resetDTO);
					logger.debug(validOtp);
					
					if (validOtp) {
						dao.resetPassword( resetDTO);
						logger.debug("otp is valid and password updated");
						return "valid";
					} else {
						logger.debug("Invalid otp");

						return "invalid";
					}

				} else {
					logger.debug("password and confirm password not matching...");
					return "notMatching";
				}
			} else {
				logger.debug("fields can't be blank");
				return message;
			}

		} catch (RepositoryException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	@Override
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
	@Override
	public List<EcommerceDTO> loginDetails(String email) throws ServiceException {
		List<EcommerceDTO> list;
		logger.info("invoke login details method");
		try {
			list = dao.fetchRowByEmail(email);
			logger.info(list);
		} catch (RepositoryException e) {
			throw new ServiceException(e.getMessage());
		}
		return list;
		
		
	}
	@Override
	public void updateNameByEmail(String email,String fName,String lName) throws ServiceException {
		try {
			dao.updateNameByEmail(email,fName,lName);
		} catch (RepositoryException e) {
			
			throw new ServiceException(e.getMessage());
		}
		
	}
	



	

}
