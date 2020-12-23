package com.xworkz.spring.bean;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class WebBean {
	
	
	public WebBean() {
		System.out.println("Hello im default constructor of "+this.getClass().getSimpleName());
	}
	@RequestMapping("call.me")
	public String callMe() {
		System.out.println("Invoked callMe Method");
		return "/index.html";
	}

}
