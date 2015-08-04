package com.iwinner.hb.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.entity.CustomerDTO;
import com.iwinner.hb.entity.VendorDTO;
import com.iwinner.hb.utils.HibernateUtils;

public class OneToManySelectionDaoImpl {
	public static void selectSingleRecord() {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.sessionFactoryUtil();
	        
			session = sessionFactory.openSession();
			Object obj=session.get(VendorDTO.class, 18);
			VendorDTO vendorDTO=(VendorDTO)obj;	
			
			Set set=vendorDTO.getCustomerDTO();
			Iterator it=set.iterator();
			while(it.hasNext()){
				Object ob=(Object)it.next();
				CustomerDTO cDTO=(CustomerDTO)ob;
				System.out.println(cDTO.getCustomerId()+"  "+cDTO.getCustomerName());
			}
			System.out.println(vendorDTO.getVendorId()+"  "+vendorDTO.getVendorName());
			
		}catch(Exception e){
			
		}
	}
	public static Object bulkSelectionOperation(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.sessionFactoryUtil();
			session = sessionFactory.openSession();
			
			Query query=session.createQuery("from VendorDTO");
			
			List list=query.list();
			
			Iterator it=list.iterator();
			while(it.hasNext()){
				Object obj=it.next();
				VendorDTO vDTO=(VendorDTO)obj;
				
				Set sVendor=vDTO.getCustomerDTO();
				
				Iterator itVendor=sVendor.iterator();
				
				while(itVendor.hasNext()){
					Object custObj=itVendor.next();
					
					CustomerDTO cDTO=(CustomerDTO)custObj;
					
					System.out.println(cDTO.getCustomerId()+"   "+cDTO.getCustomerName()+"  "+vDTO.getVendorId()+"  "+vDTO.getVendorName());
				}
			}
			
		}catch(Exception e){
			
		}
		return null;
	}
	public static void main(String[] args) {
		//selectSingleRecord();
		bulkSelectionOperation();
	}
		
}
