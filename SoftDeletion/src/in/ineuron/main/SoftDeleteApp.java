package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

import in.ineuron.model.Account;
import in.ineuron.utils.HibernateUtils;

public class SoftDeleteApp {

	public static void main(String[] args) {
		
		Session session=null;
		boolean flag=false;
		try {			
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Account account = new Account();
			account.setAccNo(8907);
						
			session.delete(account);
			flag=true;		
		
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
