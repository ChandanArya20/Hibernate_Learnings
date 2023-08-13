package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

import in.ineuron.model.Employee;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp {

	public static void main(String[] args) {
		
		Session session=null;
		boolean flag=false;
		
		try {			
			session=HibernateUtils.getSession();
			
			Query<Employee> query = session.createQuery("FROM in.ineuron.model.Employee");			
			List<Employee> list = query.list();	
			
			System.out.println(list);
			

			
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
