package com.xworkz.page.component.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.xworkz.page.component.dto.CoronaPatientDTO;

@Component
@RequestMapping("/")
public class LandingPage {
	
	List<String> states;
	
	public LandingPage() {
		// TODO Auto-generated constructor stub
		System.out.println("created" + this.getClass().getSimpleName());
	}
	@PostConstruct
	public void init() {
		this.states=new ArrayList<String>();
		this.states.add("Karnataka");
		this.states.add("Kerala");
		this.states.add("Mumbai");
		this.states.add("Delhi");
	}

	@RequestMapping(value = "/landing.do")
	public String landingPage( Model model, HttpSession httpSession)
			throws ServletException, IOException {
		System.out.println("Invoked landingPage");
		httpSession.setAttribute("states",this.states);
		return "index";
	
			}
	@PreDestroy
	public void destroy() {
		System.out.println("Invoked Pre DESTROY method");
		this.states=null;
	}

}

