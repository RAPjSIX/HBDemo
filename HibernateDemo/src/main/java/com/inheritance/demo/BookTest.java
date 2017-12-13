package com.inheritance.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class BookTest{

	public static void main(String[] args) {

		SessionFactory ssf = new AnnotationConfiguration().configure("/hibernate.cfg.xml").buildSessionFactory();
		Session ss  = ssf.openSession();
		Transaction tt = ss.beginTransaction();
		
		Book b = new Book();
		b.setBookId(11);
		b.setBookName("java");
		b.setBookPrice(425);
		
		FictionBook fb = new FictionBook();
		fb.setBookId(22);
		fb.setBookName("Fire and Ice");
		fb.setBookPrice(654.2f);
		fb.setPageNo(845);
		fb.setPublication("Throne");
		
		//ss.save(b);
		//ss.save(fb);
		//ss.update(fb);
		
		FictionBook bb = (FictionBook) ss.get(FictionBook.class, 22);
		System.out.println(bb);
		tt.commit();
		ss.close();
		
	}

}
