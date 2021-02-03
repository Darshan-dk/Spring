package com.xworkz.commonmodules.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
					// System.out.println("Sent succesfully");
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
			List<EcommerceDTO> list = ecommerceService.loginDetails(dto);
			String message = ecommerceService.validateAndLogin(dto, loginDTO);

			for (EcommerceDTO eCommerceDTO : list) {

				logger.debug(message);
				if (message.equals("matching")) {
					m.addAttribute("message", "Welcome " + eCommerceDTO.getFirstName());
					return "Home";
				}
			}

			if (message.equals("notMatching")) {
				m.addAttribute("message", "password and confirm password matching");
				return "Login";
			}
			if (message.equals("notRegistered")) {
				m.addAttribute("message", "This is not a registered email");
				return "Login";
			}

		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return "Login";

	}

	@RequestMapping(value = "forgot.do", method = RequestMethod.POST)
	public String forgot(@ModelAttribute EcommerceDTO commerceDTO, Model m) throws ControllerException {

		try {
			System.out.println("invoked forgot.do");
			boolean reset = ecommerceService.resetPassword(commerceDTO);
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

}
