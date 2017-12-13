package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rap.com.demo.Student;

public class CriteriaDemo {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Student stud4 = new Student(4, "Tyrion", 92);
		Student stud5 = new Student(15, "wolf", 2);
	//	s.save(stud4);
	//	s.save(stud5);
		Criteria c = s.createCriteria(Student.class);
		Student t=(Student)s.load(Student.class, 4);
		System.out.println(t);
	//	c.add(Restrictions.eq("studentName", "wolf"));
		c.add(Restrictions.le("studentMarks", 65));
		List l = c.list();
		for (Object ob : l) {
			System.out.println(ob);
		}
		tx.commit();
		s.close();
	}

}
