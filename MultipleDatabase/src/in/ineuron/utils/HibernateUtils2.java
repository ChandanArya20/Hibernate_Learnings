package in.ineuron.utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import in.ineuron.model.Products;

public class HibernateUtils2 {
	static SessionFactory sessionFactory=null;
	static Session session=null;
	
	static {

		sessionFactory=new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Products.class).buildSessionFactory();	
	}
	public static Session getSession() {
		if(session==null)
			session=sessionFactory.openSession();
		return session;		
	}
	public static void closeSession() {
		if(session!=null)
			session.close();
	}
	public static void closeSessionFactory() {
		if(sessionFactory!=null)
			sessionFactory.close();
	}
	
}
