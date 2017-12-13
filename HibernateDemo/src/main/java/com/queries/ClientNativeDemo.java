package com.queries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientNativeDemo {

	public static void main(String[] args) {
		Client c = new Client(1, "Google");
		Client c1 = new Client(2, "Google");
		Client c2 = new Client(3, "Microsoft");
		Client c3 = new Client(4, "IBM");
		
		SessionFactory ssf = new Configuration().configure().buildSessionFactory();
		Session ss = ssf.openSession();
		Transaction tt = ss.beginTransaction();
	/*	ss.save(c);
		ss.save(c1);
		ss.save(c2);
		ss.save(c3);*/
		
		Query q = ss.getNamedQuery("findbyname");
		

		List l = q.list();
		for (Object ob : l) {
			System.out.println(ob);
		}
		tt.commit();
		ss.close();
		
		
	}

}
