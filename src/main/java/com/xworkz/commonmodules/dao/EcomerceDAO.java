package com.xworkz.commonmodules.dao;

import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.exception.RepositoryException;

public interface EcomerceDAO {

	public int save(EcommerceDTO dto) throws RepositoryException;

	public long fetchEmailCount(EcommerceDTO dto) throws RepositoryException;

}
