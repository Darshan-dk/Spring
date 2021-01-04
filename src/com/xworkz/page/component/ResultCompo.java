package com.xworkz.page.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.page.component.service.CorornaService;
import com.xworkz.page.component.dto.CoronaPatientDTO;


@Component
@RequestMapping("/")
public class ResultCompo {
	
	@Autowired
	private CorornaService coronaService;
	
	
	
	private List<CoronaPatientDTO> coronaPatientDTOs = new ArrayList<CoronaPatientDTO>();

	
	public ResultCompo() {
		// TODO Auto-generated constructor stub
		System.out.println( "created" +this.getClass().getSimpleName());
	}
	
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute CoronaPatientDTO coronaPatientDTO, Model model)
			throws ServletException, IOException {
		System.out.println("Invoked add product");
		
		boolean saved=coronaService.validateAndSave(coronaPatientDTO);
		if(saved) {
			System.out.println(coronaPatientDTO);
			this.coronaPatientDTOs.add(coronaPatientDTO);
			model.addAttribute("list",this.coronaPatientDTOs);
			return "success";
		}
		else {
			return "index";			
		}
		
	
		
	}
	
	@RequestMapping(value = "/display.do", method = RequestMethod.POST)
	public String showDetails( Model model)
			throws ServletException, IOException {
		System.out.println("Invoked dispaly page");
		
		model.addAttribute("list",this.coronaPatientDTOs);
		return "result";
	
	
}

}
