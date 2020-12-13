package com.xworkz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.dto.CoronaVaccineDTO;

import lombok.Setter;

@Setter
public class CoronaVaccineDAO {
	
	private SessionFactory factory ;
	
	public CoronaVaccineDAO(SessionFactory factory) {
		System.out.println(this.getClass().getSimpleName()+ " created");
		this.factory=factory;
		
	}
	
	public void save(CoronaVaccineDTO dto) {
		Session session=null;
		Transaction transaction=null;
		
		try {
//			Configuration config = new Configuration();
//			config.configure("resources/hibernate.cfg.xml");
//			 factory = config.buildSessionFactory();
			 session = factory.openSession();
			 transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(transaction!=null)
				transaction.rollback();
		}finally {
			if(session!=null)
				session.close();
			
		}
	}

}
