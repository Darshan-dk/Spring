package com.xworkz.page.component.dao;

import org.springframework.stereotype.Component;

import com.xworkz.page.component.dto.CoronaPatientDTO;

@Component
public interface CoronaDao {
	
	public long save(CoronaPatientDTO dto);

}
