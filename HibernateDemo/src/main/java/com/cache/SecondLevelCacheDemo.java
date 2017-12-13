package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.rap.com.demo.Student;

public class SecondLevelCacheDemo {

	public static void main(String[] args) {
		Student st1 = new Student(101, "Jon snow", 45);
		Student st2 = new Student(102, "Tyrion", 65);
		Student st3 = new Student(103, "Jammy", 45);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Student g = (Student)s.get(Student.class, 1);
		System.out.println(g);
		Student g1 = (Student)s.get(Student.class, 0);
		System.out.println(g1);
		s.close();
		
		Session s1 = sf.openSession();
		Student sg = (Student)s1.get(Student.class, 2);
		System.out.println(sg);
		Student sg1 = (Student)s1.get(Student.class, 0);
		System.out.println(sg1);
		s1.close();
		sf.close();

	}

}
