package com.iwinner.hb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.entity.ProfileDTO;
import com.iwinner.hb.entity.UserAccountDTO;
import com.iwinner.hb.utils.HibernateUtils;

public class ManyToOneInsertionDaoImpl {

	public static void startOperation(){
		
		
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try {
			sessionFactory=HibernateUtils.sessionFactoryUtil();
			session =sessionFactory.openSession();
			tx=session.beginTransaction();
			ProfileDTO pDTO=new ProfileDTO();
			pDTO.setProfileId(10);
			pDTO.setProfileName("ABC");
			
			UserAccountDTO userAccount=new UserAccountDTO();
			userAccount.setCompanyName("Infy");
			userAccount.setEmailId("shekar@gmail.com");
			userAccount.setFirstName("abc");
			userAccount.setUserProfile(pDTO);
			
			session.save(userAccount);
			
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
		
	}
	public static void main(String[] args) {
		startOperation();
	}
}
