package com.xworkz.commonmodules.dao;

import java.util.List;

import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.dto.ResetDTO;
import com.xworkz.commonmodules.exception.RepositoryException;

public interface EcomerceDAO {

	public int save(EcommerceDTO dto) throws RepositoryException;

	public long fetchEmailCount(EcommerceDTO dto) throws RepositoryException;
	public String fetchPassword(EcommerceDTO dto) throws RepositoryException;
	public List<EcommerceDTO> fetchRow(EcommerceDTO dto) throws RepositoryException;
	public List<EcommerceDTO> fetchTable(EcommerceDTO dto) throws RepositoryException;
	public boolean isValidUser(EcommerceDTO dto) throws RepositoryException;
	public String updatePassword(EcommerceDTO commerceDTO) throws RepositoryException;
	public boolean isValidOtp(ResetDTO dto) throws RepositoryException;
	public boolean resetPassword( ResetDTO resetDTO) throws RepositoryException;
}
