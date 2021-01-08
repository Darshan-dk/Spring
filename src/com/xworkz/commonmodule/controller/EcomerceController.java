package com.xworkz.commonmodule.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.commonmodule.dto.EcommerceDTO;
import com.xworkz.commonmodule.exception.ControllerException;
import com.xworkz.commonmodule.exception.RepositoryException;
import com.xworkz.commonmodule.exception.ServiceException;
import com.xworkz.commonmodule.service.EcommerceService;

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
	public String addProduct(@ModelAttribute EcommerceDTO ecommerceDTO, Model model, HttpServletRequest req)throws  ControllerException, ServiceException
			{
		System.out.println("Invoked add product");

		
		try {
			boolean saved = ecommerceService.validateAndSave(ecommerceDTO);
			if (saved) {
				String msg="Saved succesfully ";
				System.out.println(ecommerceDTO);
				req.setAttribute("message", msg);
				return "LandingPage";
			}else
				req.setAttribute("errMessage", "Saving failed please give valid data");
			
		}

		
			catch (Exception e) {
				throw new ServiceException(e.getMessage());
			
		} 
		System.out.println(ecommerceDTO);
		return "LandingPage";

	}

}

