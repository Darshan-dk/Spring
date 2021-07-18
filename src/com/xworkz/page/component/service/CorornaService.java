package com.xworkz.page.component.service;

import com.xworkz.page.component.dto.CoronaPatientDTO;
import com.xworkz.page.component.exception.ServiceException;

public interface CorornaService  {
	
	public boolean validateAndSave(CoronaPatientDTO dto) throws ServiceException;
	

}
