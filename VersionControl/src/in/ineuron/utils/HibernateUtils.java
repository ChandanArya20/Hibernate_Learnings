package in.ineuron.utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.MobileCustomer;

public class HibernateUtils {
	static SessionFactory sessionFactory=null;
	static Session session=null;
	
	static {

		sessionFactory=new Configuration().configure().addAnnotatedClass(MobileCustomer.class).buildSessionFactory();	
	}
	public static Session getSession() {
		if(session==null)
			session=sessionFactory.openSession();
		return session;		
	}
	public static void closeSession(Session session) {
		if(session!=null)
			session.close();
	}
	public static void closeSessionFactory() {
		if(sessionFactory!=null)
			sessionFactory.close();
	}
	
}
