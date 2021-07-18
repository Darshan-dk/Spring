package com.xworkz.page.component.dao;

import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.stereotype.Component;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.xworkz.page.component.dto.CoronaPatientDTO;

public class CoronaDaoImpl implements CoronaDao {
	private SessionFactory factory;

	public CoronaDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public CoronaDaoImpl(SessionFactory factory) {
		System.out.println(this.getClass().getSimpleName() + " created");
		this.factory = factory;

	}

	@Override
	public long save(CoronaPatientDTO dto) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		long id = dto.getId();
		try {

			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();

			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();

		}

		return id;

	}

}