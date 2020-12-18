package com.xworkz.electionresult.dao;

import java.util.List;

import com.xworkz.electionresult.dto.ElectionResultDto;

public interface ElectionDao {
	
	
	public void save(ElectionResultDto dto);
	public void deleteById(int electionId);
	public void updateWardNoById(int electionId, int wardNo);
	public ElectionResultDto getByPartyName(String name);
	public void getList(ElectionResultDto dto);

}
