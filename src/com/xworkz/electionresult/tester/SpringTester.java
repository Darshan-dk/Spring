package com.xworkz.electionresult.tester;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.electionresult.dao.ElectionDao;
import com.xworkz.electionresult.dao.ElectionResultDaoImpl;
import com.xworkz.electionresult.dto.ElectionResultDto;
import com.xworkz.electionresult.service.ElectionResultService;

public class SpringTester {
	public static void main(String[] args) {
		
		try(ClassPathXmlApplicationContext container= new ClassPathXmlApplicationContext("resources/tester.xml")){
			System.out.println(Arrays.toString(container.getBeanDefinitionNames()));
			
			
			ElectionDao dao = container.getBean(ElectionDao.class);
			
			ElectionResultDto dto = new ElectionResultDto();
			dto.setName("");
			dto.setNoOfCandidate(25);
			dto.setWardNo(324);
			
			ElectionResultService service = container.getBean(ElectionResultService.class);
			//service.validateAndSave(dto);
			//service.validateAndDeleteById(-1);
			//service.validateAndGetList(dto);
			service.validateAndupdateWardNoById(4,400);
			//service.validateAndGetByPartyName("BJP");
	}

}
}
