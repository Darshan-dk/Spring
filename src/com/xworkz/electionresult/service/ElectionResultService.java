package com.xworkz.electionresult.service;

import java.util.List;

import com.xworkz.electionresult.dto.ElectionResultDto;

public interface ElectionResultService {
	
	public String  validateAndSave(ElectionResultDto dto);
	public void validateAndDeleteById(int electionId);
	public void validateAndupdateWardNoById(int electionId, int wardNo);
	public ElectionResultDto validateAndGetByPartyName(String name);
	public List<ElectionResultDto> validateAndGetList(ElectionResultDto dto);
}


