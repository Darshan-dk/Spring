package com.xworkz.commonmodule.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xworkz.commonmodule.dto.EcommerceDTO;
import com.xworkz.commonmodule.exception.RepositoryException;

@Repository
public class EcomerceDaoImpl implements EcomerceDAO {
	@Autowired

	private SessionFactory factory;

	public EcomerceDaoImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public int save(EcommerceDTO dto) throws RepositoryException {
		Session session = null;
		Transaction transaction = null;
		int id = dto.getId();
		try {
			try {

				session = factory.openSession();
				transaction = session.beginTransaction();
				session.save(dto);
				transaction.commit();

				if (transaction != null)
					transaction.rollback();
			} catch (Exception e) {
				throw new RepositoryException(e.getMessage());

			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

}
