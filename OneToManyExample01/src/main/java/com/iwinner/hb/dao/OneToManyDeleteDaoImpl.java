package com.iwinner.hb.dao;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.entity.CustomerDTO;
import com.iwinner.hb.entity.VendorDTO;
import com.iwinner.hb.utils.HibernateUtils;

public class OneToManyDeleteDaoImpl {

	public static void deleteOperation() {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.sessionFactoryUtil();

			session = sessionFactory.openSession();
			VendorDTO vendorDTO = (VendorDTO)session.get(VendorDTO.class, 8);

			Set<CustomerDTO> set = vendorDTO.getCustomerDTO();

			tx = session.beginTransaction();

			for (CustomerDTO cust : set) {
				session.delete(cust);
			}

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSession(session);
		}

	}

	public static void main(String[] args) {
		deleteOperation();
	}
}
