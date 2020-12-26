package com.xworkz.webapps;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")

public class WebBeans {

	public WebBeans() {
		System.out.println("Default constructor of the" + this.getClass().getSimpleName());
	}

//	@RequestMapping("home.do")
//	public String callMe() {
//		System.out.println("Invoked Home Method");
//		return "/index.html";
//	}
	@RequestMapping("/home.do")
	public String onClick( String ename,String msg,Long mbl) {
		System.out.println("Invoeked by submit");
		System.out.println("Entered by: "+ename);
		System.out.println("Message: "+msg);
		System.out.println("Mobile: "+mbl);

		
		return  "/index.html";
		
	}
	@RequestMapping("**/add.do")
	public String onClick( ) {
		System.out.println("Invoked add function");
		return  "/html/add.html";
		
	}
	
	@RequestMapping("**/search.do")
	public String onClick( String src) {
		System.out.println("Invoked Search function");
		if(src.equalsIgnoreCase("india")) {
			return  "/html/search.html";
		}
		else return  "/index.html";
		
	}

}
