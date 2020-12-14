package com.xworkz.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.xworkz.dto.CoronaVaccineDTO;

public class CoronaVaccineDAO {

	private SessionFactory factory;

	public CoronaVaccineDAO(SessionFactory factory) {
		System.out.println(this.getClass().getSimpleName() + " created");
		this.factory = factory;

	}

	public void save(CoronaVaccineDTO dto) {
		Session session = null;
		Transaction transaction = null;

		try {
//			Configuration config = new Configuration();
//			config.configure("resources/hibernate.cfg.xml");
//			 factory = config.buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
//			if(factory!=null)
//				factory.close();

		}
	}

	public void update(long vaccineId, String name) {
		Session session = null;
		Transaction transaction = null;

		session = factory.openSession();
		transaction = session.beginTransaction();
		CoronaVaccineDTO dto1 = session.get(CoronaVaccineDTO.class, vaccineId);
		if (dto1 != null) {
			dto1.setName(name);
			session.update(dto1);
		}
		transaction.commit();
		session.close();

	}

//	public void update(String name, String country, long id){
//		Session session = null;
//		Transaction transaction = null;
//		
//		try {
//			session=factory.openSession();
//			transaction=session.beginTransaction();
//			Query query=session.createQuery("update CoronaVaccineDTO set name=:n,country=:c where vaccineId=:id");
//			query.setParameter("n",name);
//			query.setParameter("c",country);
//			query.setParameter("id",id);
//			query.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	public void fetch(long vaccineId) {
		Session session = null;
		Transaction transaction = null;

		session = factory.openSession();
		transaction = session.beginTransaction();
		CoronaVaccineDTO dto1 = session.get(CoronaVaccineDTO.class, vaccineId);
		System.out.println(dto1);
		session.close();

	}

	public void delete(long vaccineId) {
		Session session = null;
		Transaction transaction = null;

		session = factory.openSession();
		transaction = session.beginTransaction();
		CoronaVaccineDTO dto1 = session.get(CoronaVaccineDTO.class, vaccineId);
		session.delete(dto1);
		transaction.commit();
		session.close();

	}

}
