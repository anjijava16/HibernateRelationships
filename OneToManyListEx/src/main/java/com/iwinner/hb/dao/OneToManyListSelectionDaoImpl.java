package com.iwinner.hb.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.entity.DepartmentDTO;
import com.iwinner.hb.entity.EmployeeDTO;
import com.iwinner.hb.utils.HibernateUtils;

public class OneToManyListSelectionDaoImpl {
	public static void startOperation() {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.sessionFactoryUtil();
			session = sessionFactory.openSession();
			DepartmentDTO dTO=(DepartmentDTO)session.get(DepartmentDTO.class, new Long(50));
			List listOfEmployess=dTO.getEmployees();
			Iterator it=listOfEmployess.iterator();
			while(it.hasNext()){
				Object emp=(Object)it.next();
				EmployeeDTO empDTO=(EmployeeDTO)emp;
				System.out.println(empDTO.getEmployeeId());
			}
			System.out.println(dTO.getDepartmentName());
		} catch (Exception e) {
                e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		startOperation();
	}
}
