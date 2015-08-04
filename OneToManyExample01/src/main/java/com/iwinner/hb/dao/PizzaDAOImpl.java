package com.iwinner.hb.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.entity.PizzaDTO;
import com.iwinner.hb.utils.HibernateUtils;

public class PizzaDAOImpl {

	public static Object startOperation() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.sessionFactoryUtil();
			session = sessionFactory.openSession();
			// select distinct p from PizzaDTO as p left join fetch p.toppings
			Query query = session
					.createQuery("select distinct p from PizzaDTO as p left join fetch p.toppings");

			List list = query.list();

			System.out.println(list.size());
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object obj = it.next();
				PizzaDTO pizza = (PizzaDTO) obj;
				System.out.println(pizza);
				
			}

		} catch (Exception e) {

		}

		return null;
	}

	public static void main(String[] args) {
		startOperation();
	}
}
