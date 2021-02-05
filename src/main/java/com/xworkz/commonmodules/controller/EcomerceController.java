package com.xworkz.commonmodules.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.commonmodules.constants.AppConstant;
import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.dto.LoginDTO;
import com.xworkz.commonmodules.dto.ResetDTO;
import com.xworkz.commonmodules.exception.ControllerException;
import com.xworkz.commonmodules.exception.RepositoryException;
import com.xworkz.commonmodules.exception.ServiceException;
import com.xworkz.commonmodules.service.EcommerceService;
import com.xworkz.commonmodules.service.EmailService;
import com.xworkz.commonmodules.service.PasswordResetService;

@RequestMapping("/")
@Component
public class EcomerceController {

	static Logger logger = Logger.getLogger(EcomerceController.class);

	@Autowired
	private EcommerceService ecommerceService;

	/*
	 * @Autowired private EmailService emailService;
	 */

	public EcomerceController() {
		// TODO Auto-generated constructor stub
		System.out.println("created" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute EcommerceDTO ecommerceDTO, Model model, HttpServletRequest req)
			throws ControllerException, ServiceException {
		System.out.println("Invoked add product");

		try {
			String saved = ecommerceService.validateAndSave(ecommerceDTO);
			if (saved.equals("duplicate")) {
				model.addAttribute("errMessage", "Email is duplicte please provide a valid email");
				System.out.println("Not saved");

				System.out.println(ecommerceDTO);

				return AppConstant.LANDING_PAGE;
			}
			if (saved.equals("saved")) {
				model.addAttribute("message", "Saved Successfully");
				System.out.println("saved");
				boolean sent = ecommerceService.sendMail(ecommerceDTO);
				if (sent) {
					// System.out.println("Sent successfully");
					logger.debug("Sent succesfully");
					model.addAttribute("meesage", "Mail sent successfully");
				} else {
					// System.out.println("Sending failed");
					logger.debug("Sending failed");
					model.addAttribute("meesage", "Sending failed");
				}

				System.out.println(ecommerceDTO);

				return AppConstant.LANDING_PAGE;
			} else
				model.addAttribute("message", " Failed to save please check the data ");

		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}

		catch (Exception e) {
			throw new ServiceException(e.getMessage());

		}
		System.out.println(ecommerceDTO);
		return AppConstant.LANDING_PAGE;

	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute EcommerceDTO dto, @ModelAttribute LoginDTO loginDTO, Model m)
			throws ControllerException {
		try {
			List<EcommerceDTO> list=ecommerceService.loginDetails(dto);
			String message = ecommerceService.validateAndLogin(dto,loginDTO);
			
			for (EcommerceDTO eCommerceDTO : list) {
				
				logger.debug(message);
				if(message.equals("matching")){
					m.addAttribute("message","Hi "+eCommerceDTO.getFirstName());
					m.addAttribute( "m",eCommerceDTO);
					return "Home";
				}
			}
			
			if(message.equals("notMatching")){
				m.addAttribute("message","Incorrect password you only have 3 attempts");
				return "LoginPage";
			}
			if(message.equals("trialsExceeded")){
				m.addAttribute("message","Password attempts exceeded your account will be locked, please use forgot password");
				return "LoginPage";
			}
			if(message.equals("locked")){
				m.addAttribute("message","Your account is locked, please use forgot password");
				return "LoginPage";
			}if(message.equals("notRegistered")){
				m.addAttribute("message","This is not a registered email");
				return "LoginPage";
			}

		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return "LoginPage";

	}

	@RequestMapping(value = "forgot.do", method = RequestMethod.POST)
	public String forgot(@ModelAttribute EcommerceDTO commerceDTO,LoginDTO dto1, Model m) throws ControllerException {

		try {
			System.out.println("invoked forgot.do");
			boolean reset = ecommerceService.resetPassword(commerceDTO, dto1);
			if (!reset) {
				m.addAttribute("message", "This email is not registered");
				return "ForgotPassword";

			} else
				System.out.println("mail is registered");
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		return "Reset";

	}

	@RequestMapping(value = "/reset.do", method = RequestMethod.POST)
	public String resetPassword(@ModelAttribute ResetDTO dto, @ModelAttribute EcommerceDTO commerceDTO, Model m)
			throws ControllerException {
		try {
			String vaildAndUpdated = ecommerceService.validateAndUpdatePassword(dto);

			if (vaildAndUpdated.equals("valid")) {
				m.addAttribute("reset", "Password updated");
			} else if (vaildAndUpdated.equals("invalid")) {
				m.addAttribute("reset", "Invalid otp");
			} else if (vaildAndUpdated.equals("notMatching")) {
				m.addAttribute("reset", "Password and confirm password not matching");
			} else if (vaildAndUpdated.equals("NA")) {
				m.addAttribute("reset", "Please fill fields with valid data");
			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		return "Reset";
	}
	@RequestMapping(value="/editname/{email:.+}") 
	public String userDetails( @PathVariable("email") String email ,Model m) throws ControllerException{
		System.out.println("invoked fetch");
		logger.info("Invoked fetch method");
		logger.info(email);
		try {
			List<EcommerceDTO> list=ecommerceService.loginDetails(email);
			logger.info(list);
			for (EcommerceDTO eCommerceDTO : list) {
				m.addAttribute("list",eCommerceDTO);
				logger.info("inside for each");
				logger.info(eCommerceDTO.getFirstName());
			}
			
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		
		return "UserDetails";
		
	}

	
	@RequestMapping(value="/update", method=RequestMethod.POST ) 
	public String updateDetails(String email, String firstName,String secondName, Model m) throws ControllerException{
		System.out.println("Update method is invoked");
		logger.info("update method invoked");
		logger.info(email);
		System.out.println(email);
		
		try {
			ecommerceService.updateNameByEmail(email, firstName, secondName);
			System.out.println("Updatead successfully");
			m.addAttribute("success","Update success");
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		
		return "UserDetails";
		
	}

}
