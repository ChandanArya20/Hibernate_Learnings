package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.utils.HibernateUtils;

public class SoftDeleteApp {

	public static void main(String[] args) {
		
		Session session=null;
		boolean flag=false;
		try {			
			session=HibernateUtils.getSession();
			
			
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag==true)
				session.getTransaction().commit();
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
