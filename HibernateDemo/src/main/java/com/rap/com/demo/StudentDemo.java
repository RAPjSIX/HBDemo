package com.rap.com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class StudentDemo {

	public static void main(String[] args) {

		Student stud1 = new Student(2, "Abhi", 95);
		Student stud3 = new Student(3, "Aegon", 88);
		Student stud4 = new Student(4, "Tyrion", 92);
		Student stud2 = new Student();
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		stud2.setStudentName("hi");
		s.save(stud1);
		s.save(stud2);
		s.save(stud3);
		
		Student s1 = (Student) s.get(Student.class, 2);
		
		s1.setStudentMarks(65);
		// s.update(stud);

		// s.flush();
		stud2.setStudentMarks(44);
		tx.commit();
		
		Student stud6 = new Student(5, "Sangram", 85);
		Student stud5 = new Student(6, "Sam", 85);
	//	s.save(stud6);
	
		Student stud7 = new Student(8, "wolf", 5);
		s.save(stud7);
		s.flush();
		
		s.close();

		Session sn = sf.openSession();
		Transaction tn = sn.beginTransaction();
		Student s2 = (Student) sn.get(Student.class, 1);
		// s2.setStudentMarks(25);
		//sn.update(s1);
		//sn.save(stud6);
		tn.commit();
		
		Student stud8 = new Student(9, "olf", 15);
		sn.save(stud8);
		sn.flush();
		
		sn.close();
		sf.close();
		System.out.println("data updated succefully............");
	}

}
