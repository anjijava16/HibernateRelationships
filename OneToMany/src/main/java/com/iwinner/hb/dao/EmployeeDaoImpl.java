package com.iwinner.hb.dao;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.entity.EmployeeEntity;
import com.iwinner.hb.utils.HibernateUtils;

public class EmployeeDaoImpl {

	public static void startOperation(){
		
		
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try {
			sessionFactory=HibernateUtils.sessionFactoryUtil();
			
			session=sessionFactory.openSession();
			EmployeeEntity empEntity=new EmployeeEntity();
			tx=session.beginTransaction();
			empEntity.setEmpId(80);
			empEntity.setEmpName("ABC");
			empEntity.setEmpDesg("Dev");
			session.save(empEntity);
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
