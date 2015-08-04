package com.iwinner.hb.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.entity.CustomerDTO;
import com.iwinner.hb.entity.VendorDTO;
import com.iwinner.hb.utils.HibernateUtils;

public class OneToManyInsertionOps {
	public static void startOperation() {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.sessionFactoryUtil();

			session =sessionFactory.openSession();
				tx=session.beginTransaction();
				
				
				// Child Object creation here cust1
				CustomerDTO cust1=new CustomerDTO();
				cust1.setCustomerId(7);
				cust1.setCustomerName("AT");
				cust1.setCustomerRegDate(new Date());
				cust1.setCustomerRegTime(new Timestamp(new Date().getTime()));
				cust1.setCustomerAdd("USA");
				
				
				// Child Object creation here cust2
				CustomerDTO cust2=new CustomerDTO();
				cust2.setCustomerId(8);
				cust2.setCustomerName("HBC");
				cust2.setCustomerRegDate(new Date());
				cust2.setCustomerRegTime(new Timestamp(new Date().getTime()));
				cust2.setCustomerAdd("USA");
				
				// Parent Object creation 
				VendorDTO vendor=new VendorDTO();
				vendor.setVendorId(10);
				vendor.setVendorName("Iwinner");
				vendor.setVendorAdd("Hyderabad");

				// Adding the Child Objects into Parent Object means (One to Many) One parent contains many child object's
				Set<CustomerDTO> setCustomer=new HashSet<CustomerDTO>();
				setCustomer.add(cust1);
				setCustomer.add(cust2);
				
				// Inserting the parent object mens child object also saved into Database
				vendor.setCustomerDTO(setCustomer);
				
				
				session.save(vendor);
				
				tx.commit();
				
			session = sessionFactory.openSession();

		} catch (Exception e) {
                e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		startOperation();
	}
}
