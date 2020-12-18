package com.xworkz.electionresult.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.electionresult.dto.ElectionResultDto;

public class ElectionResultDaoImpl implements ElectionDao {

	private SessionFactory factory;
	
	public ElectionResultDaoImpl(SessionFactory factory) {
	System.out.println(this.getClass().getSimpleName()+" created");
	this.factory=factory;
	}

	@Override
	public void save(ElectionResultDto dto) {
		Session session = null;
		Transaction transaction = null;
		

		try {
			session = factory.openSession();
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
		}

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete from ElectionResultDto where electionId=:id ");
			query.setParameter("id", id);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public void updateWardNoById(int wardNo, int electionId) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update ElectionResultDto set wardNo=:wn where electionId=:id");
			query.setParameter("wn", wardNo);
			query.setParameter("id", electionId);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public ElectionResultDto getByPartyName(String name) {
		Session session = null;
		ElectionResultDto dto = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery(" from ElectionResultDto where name=:name");
			query.setParameter("name", name);
			dto = (ElectionResultDto) query.uniqueResult();
			System.out.println(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;

	}

	@Override
	public void getList(ElectionResultDto dto) {
		Session session = null;
		List<ElectionResultDto> list = null;
		System.out.println("fetch by list");
		try {
			session = factory.openSession();
			Query query = session.createQuery("from ElectionResultDto");
			list = (List<ElectionResultDto>) query.list();
			for (ElectionResultDto electionResultDto : list) {
				System.out.println(electionResultDto);
			}

			System.out.println(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
