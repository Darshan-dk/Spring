package com.xworkz.commonmodules.dao;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.commonmodules.dto.EcommerceDTO;
import com.xworkz.commonmodules.dto.LoginDTO;
import com.xworkz.commonmodules.dto.ResetDTO;
import com.xworkz.commonmodules.exception.RepositoryException;

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
		Session session=null;
		long n; 
		String email=dto.getEmail();
		try {
			session=factory.openSession();
			Query query= session.createQuery("select count(*) from EcommerceDTO where email=:e ");
			query.setParameter("e", email);
			n=(Long)query.uniqueResult();
			//logger.debug(n);
			System.out.println(n);
		} catch (Exception e) {
			
			throw new RepositoryException(e.getMessage());
			
		}
		return n;
	}

	public List<EcommerceDTO> fetchRow(EcommerceDTO dto) throws RepositoryException {
		List<EcommerceDTO> list=null;
		Session session=null;
		try {
			session=factory.openSession();
			Query query =session.createQuery("from EcommerceDTO where email=:e");
			query.setParameter("e", dto.getEmail());
			list=(List<EcommerceDTO>)query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close(); 
		}
		return list;
	}

	@Override
	public String fetchPassword(EcommerceDTO dto) throws RepositoryException {
		Session session=null;
		String password=null;
		try {
			session=factory.openSession();
			Query query =session.createQuery("select password from EcommerceDTO where email=:e");
			query.setParameter("e", dto.getEmail());
			password=(String)query.uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
	@Override
	public List<EcommerceDTO> fetchTable(EcommerceDTO dto) throws RepositoryException {
		List<EcommerceDTO> list = null;
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from EcommerceDTO ");

			list = (List<EcommerceDTO>) query.list();

		} catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return list;
	}

	
	

	@Override
	public boolean isValidUser(EcommerceDTO dto) throws RepositoryException {
		Session session = null;
		long count = 0;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select count(1) from EcommerceDTO where email=:e and password=:p");
			query.setParameter("e", dto.getEmail());
			query.setParameter("p", dto.getPassword());

			count = (long) query.uniqueResult();
			if (count > 0)
				return true;
		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public String updatePassword(EcommerceDTO commerceDTO) throws RepositoryException {
		Session session = null;
		String randomString = null;
		Transaction transaction = null;
		randomString = RandomStringUtils.random(5, true, false);
		//logger.debug(randomString);
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update EcommerceDTO set password=:p where email=:e");
			query.setParameter("e", commerceDTO.getEmail());
			query.setParameter("p", randomString);

			int status = query.executeUpdate();
			//logger.debug(status);
			transaction.commit();
			return randomString;
		} catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		

	}

	@Override
	public boolean isValidOtp(ResetDTO dto) throws RepositoryException {
		Session session = null;
		long count = 0;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select count(*) from EcommerceDTO where password=:p");

			query.setParameter("p", dto.getPassword());

			count = (long) query.uniqueResult();
			if (count > 0)
				return true;
		} catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean resetPassword( ResetDTO resetDTO) throws RepositoryException {
		Session session = null;

		Transaction transaction = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update EcommerceDTO set password=:p where password=:q");
			query.setParameter("p", resetDTO.getNewPassword());
			query.setParameter("q", resetDTO.getPassword());
			
			
			int status = query.executeUpdate();
			//logger.debug(status);
			transaction.commit();
			return true;
		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		
	}
	@Override
	public  Integer updateLoginFailCount(LoginDTO dto) throws RepositoryException {
		Session session = null;
		int status = 0;
		Transaction transaction=null;
		try {
			session = factory.openSession();
			transaction=session.beginTransaction();
			Query query = session.createQuery("update EcommerceDTO set invalidLoginCount=invalidLoginCount+1 where email=:e");
			query.setParameter("e", dto.getEmail());
			
			 status=query.executeUpdate();
			//logger.debug(status);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		
		return null;}
	
	@Override
	public void updateLoginFailCountToZero(String email) throws RepositoryException {
		Session session = null;
		int status = 0;
		Transaction transaction=null;
		try {
			session = factory.openSession();
			transaction=session.beginTransaction();
			Query query = session.createQuery("update EcommerceDTO set invalidLoginCount=:c where email=:e");
			query.setParameter("c", 0);
			query.setParameter("e", email);
			
			 status=query.executeUpdate();
			//logger.debug(status);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
	}
	@Override
	public void accountUnlocking(String email) throws RepositoryException {
		Session session = null;
		int status = 0;
		Transaction transaction=null;
		try {
			session = factory.openSession();
			transaction=session.beginTransaction();
			Query query = session.createQuery("update EcommerceDTO set accountStatusLocked=:c where email=:e");
			query.setParameter("c",false);
			query.setParameter("e", email);
			
			 status=query.executeUpdate();
			//logger.debug(status);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
	};

	@Override
	public void updateAccountLockedToFalse(String email) throws RepositoryException {
		Session session = null;
		int status = 0;
		Transaction transaction=null;
		try {
			session = factory.openSession();
			transaction=session.beginTransaction();
			Query query = session.createQuery("update EcommerceDTO set accountStatusLocked=:b where email=:e");
			query.setParameter("b", false);
			query.setParameter("e", email);
			
			 status=query.executeUpdate();
			//logger.debug(status);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
	};
	
	@Override
	public  boolean updateAccountLocked(LoginDTO loginDTO) throws RepositoryException {
		Session session = null;
		int status = 0;
		Transaction transaction=null;
		try {
			session = factory.openSession();
			transaction=session.beginTransaction();
			Query query = session.createQuery("update EcommerceDTO set accountStatusLocked=:b where email=:e");
			query.setParameter("b", true);
			query.setParameter("e", loginDTO.getEmail());
			
			 status=query.executeUpdate();
			//logger.debug(status);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return false;
		}
	@Override
	public List<EcommerceDTO> fetchRowByEmail(String email) throws RepositoryException {
		List<EcommerceDTO> list = null;
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from EcommerceDTO where email=:e");
			query.setParameter("e", email);
			System.out.println(email);
			//logger.info(email);
			list = (List<EcommerceDTO>) query.list();
			//logger.info(list.size());
			for (EcommerceDTO eCommerceDTO : list) {
				System.out.println(eCommerceDTO);
				//logger.info(eCommerceDTO);
			}

		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return list;
	}
	@Override
	public void updateNameByEmail(String email, String firstName, String secondName) throws RepositoryException {
		
		System.out.println("updateNameByEmail invoked");
		Session session = null;

		Transaction transaction = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update EcommerceDTO set firstName=:f , secondName=:l where email=:e");
			query.setParameter("f", firstName);
			query.setParameter("l", secondName);
			query.setParameter("e", email);
			
			int status = query.executeUpdate();
			System.out.println(status);
			//logger.debug(status);
			transaction.commit();
			
		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
	}
		

}
