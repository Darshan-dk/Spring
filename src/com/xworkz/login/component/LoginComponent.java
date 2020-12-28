package com.xworkz.login.component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping
public class LoginComponent {

	public LoginComponent() {
		System.out.println("Invoking the Constructor of " + this.getClass().getSimpleName());
	}

	
	
	@RequestMapping( value="/login.do", method = RequestMethod.POST)
//	method = RequestMethod.POST will help to avoid showing credentials on web browser.
//	we also need to change the method type=post in corresponding jsp file(index.jsp)
	public String onLogin(String userName, String password, HttpServletRequest request)
	{
		System.out.println("invoked method");

		String name = "darshan";
		String pwd = "pwd";

		if (name.equalsIgnoreCase(userName) && pwd.equals(password)) {
			System.out.println("User credintials are matching");
			request.setAttribute("message", " "+userName);
			return "home";
		} 
					System.out.println("Invalid user name or password");
					request.setAttribute("errmessage","Invalid user name or password");
					return "index";
		
			

	}

}
