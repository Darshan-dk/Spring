package com.xworkz.commonmodule.dao;

import com.xworkz.commonmodule.dto.EcommerceDTO;
import com.xworkz.commonmodule.exception.RepositoryException;

public interface EcomerceDAO {

	public int save(EcommerceDTO dto) throws RepositoryException;

}
