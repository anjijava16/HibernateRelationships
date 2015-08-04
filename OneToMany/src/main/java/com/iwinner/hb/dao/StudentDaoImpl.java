package com.iwinner.hb.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.iwinner.hb.entity.Book;
import com.iwinner.hb.entity.Student;
import com.iwinner.hb.utils.HibernateUtils;

public class StudentDaoImpl {
	public static void saveStudent() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.sessionFactoryUtil();
			session = sessionFactory.openSession();
			Student student = new Student();
			student.setstudentId(2);
			student.setstudentName("Raman");
			Book book1 = new Book();
			book1.setbookId(14);
			book1.setbookName("Science");
			Book book2 = new Book();
			book2.setbookId(15);
			book2.setbookName("Maths");
			Set books = new HashSet();
			books.add(book1);
			books.add(book2);
			student.setbook(books);
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
			session.close();
			System.out.println("Student Record Saved");
			sessionFactory.close();

		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		saveStudent();
	}
}