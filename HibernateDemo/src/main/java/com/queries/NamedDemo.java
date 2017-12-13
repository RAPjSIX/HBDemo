package com.queries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class NamedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeName em = new EmployeeName();
		EmployeeName emm = new EmployeeName();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		em.setEmpId(1);
		em.setEmpName("Abhi");
		emm.setEmpId(2);
		emm.setEmpName("Abhi");
		//s.save(em);
		//s.save(emm);
		Query q = s.getNamedQuery("Emplo");
		q.setString("name", "Abhi");
		List ls = q.list();
		for (Object object : ls) {
			EmployeeName p = (EmployeeName)object;
			System.out.println(p.getEmpId()+"***"+p.getEmpName());
		}
		
		String hql ="FROM EmployeeName AS E";
		Query query =s.createQuery(hql);
		List results =query.list();
		for (Object obj : results) {
			System.out.println(obj);
		}
		tx.commit();
		s.close();

	}

}
