
package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

import in.ineuron.utils.HibernateUtils;

public class RetrieveApp4 {

	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
				Query<Integer> query = session.createQuery("SELECT price FROM in.ineuron.model.Products WHERE pname IN(:prod1,:prod2)");				
				query.setParameter("prod1", "soap");
				query.setParameter("prod2", "hat");
				
				List<Integer> products=query.getResultList();
							
				System.out.println("Price");
				
				products.forEach( System.out::println);	
				
			}		
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}

