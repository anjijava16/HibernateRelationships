package com.iwinner.hb.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.entity.DepartmentDTO;
import com.iwinner.hb.entity.EmployeeDTO;
import com.iwinner.hb.utils.HibernateUtils;

public class OneTomanyListInsertionDaoImpl {

	public static void startOperation() {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.sessionFactoryUtil();
			session = sessionFactory.openSession();
			tx=session.beginTransaction();
			DepartmentDTO department = new DepartmentDTO();
			department.setDepartmentName("Sales");
			department.setDepartmentId(50l);
         
			EmployeeDTO emp1 = new EmployeeDTO();
			emp1.setBirthDate(new Date());
			emp1.setCellphone("6789909");
			emp1.setEmployeeId(20l);
			emp1.setFirstname("anji");
			emp1.setLastname("ra");;
			
			EmployeeDTO emp2 = new EmployeeDTO();
			emp2.setBirthDate(new Date());
			emp2.setCellphone("678909");
			emp2.setEmployeeId(31l);
			emp2.setFirstname("ji");
			emp2.setLastname("ra");;
			
			List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();
			list.add(emp1);
			list.add(emp2);

			department.setEmployees(list);
			
			session.save(department);

			tx.commit();
		} catch (Exception e) {
              e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		startOperation();
	}
}
