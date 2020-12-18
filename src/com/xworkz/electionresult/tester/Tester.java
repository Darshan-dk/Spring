package com.xworkz.electionresult.tester;

import com.xworkz.electionresult.dao.ElectionDao;
import com.xworkz.electionresult.dao.ElectionResultDaoImpl;
import com.xworkz.electionresult.dto.ElectionResultDto;

public class Tester {
	
	public static void main(String[] args) {
		
		ElectionResultDto dto=new ElectionResultDto();
		dto.setName("nda");
		dto.setNoOfCandidate(10);
		dto.setWardNo(123);
		
//		ElectionDao dao=new ElectionResultDaoImpl();
		dao.save(dto);
		//dao.getList(dto);
		//dao.updateWardNoById(3, 3);
		//dao.deleteById(1);
		//dao.getByPartyName("jds");
		
				}
}
