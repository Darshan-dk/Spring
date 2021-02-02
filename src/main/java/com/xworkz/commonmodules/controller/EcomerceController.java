package com.xworkz.commonmodules.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.commonmodules.constants.AppConstant;
import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.exception.ControllerException;
import com.xworkz.commonmodules.exception.RepositoryException;
import com.xworkz.commonmodules.exception.ServiceException;
import com.xworkz.commonmodules.service.EcommerceService;

@RequestMapping("/")
@Component
public class EcomerceController {

	@Autowired
	private EcommerceService ecommerceService;

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

}
