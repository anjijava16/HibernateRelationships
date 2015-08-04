package com.iwinner.hb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.entity.Category;
import com.iwinner.hb.entity.Item;
import com.iwinner.hb.utils.HibernateUtils;

public class ItemManyToManyDaoImpl {
/*	public void testPersist() throws Throwable {
		final Item item = prepareDB();

		long id = item.id;
		assertTrue("ID: " + id, id > 0);

		// Clear cache to make sure the objects are loaded again from DB
		em.clear();

		Item item2 = em.find(Item.class, id);
		assertEquals(item2.categories.toString(), 2, item2.categories.size());

		delete(item2);

		item2 = em.find(Item.class, id);
		assertNull(item2);
	}

	public void flush() {
		Session session = (Session) em.getDelegate();
		session.flush();
	}

	@Transactional
	public void delete(Item item2) {
		em.remove(item2);
		// Force delete
		flush();
	}
*/
	
	public static void prepareDB() {
		SessionFactory sessionFact=HibernateUtils.sessionFactoryUtil();
		Session session=sessionFact.openSession();
		
		 Category one = new Category();
		one.setName("cat_1");
		one.setId(10);
		
		Transaction tx=session.beginTransaction();
		
		session.save(one);
		
		 Category two = new Category();
		 two.setName("cat_2");
		 two.setId(10);
		 session.save(two);
		 
		 Item item=new Item();
		 item.getCategories().add(one);
		 item.getCategories().add(two);
		 session.save(item);
		 
		 tx.commit();
	}
	public static void main(String[] args) {
		prepareDB();
	}
}
