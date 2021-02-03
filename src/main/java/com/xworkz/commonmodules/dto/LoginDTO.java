package com.xworkz.commonmodules.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO implements Serializable{

	static Logger logger=Logger.getLogger(LoginDTO.class);
	
	private String email;
	private String password;
	
	public LoginDTO() {
		logger.info("Created "+getClass().getSimpleName());
	}
}