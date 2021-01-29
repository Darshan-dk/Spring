package com.xworkz.commonmodule.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
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

			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			throw new RepositoryException(e.getMessage());
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw new RepositoryException(e.getMessage());
		}

		return id;
	}

	public long fetchEmailCount(EcommerceDTO dto) throws RepositoryException {
		Session session = null;
		long n;
		String email = dto.getEmail();
		try {
			session = factory.openSession();
			Query query = session.createQuery("select count(*) from EcommerceDTO where email=:e ");
			query.setParameter("e", email);
			n = (Long) query.uniqueResult();
			System.out.println(n);

		} catch (Exception e) {

			throw new RepositoryException(e.getMessage());

		}
		return n;
	}

}
