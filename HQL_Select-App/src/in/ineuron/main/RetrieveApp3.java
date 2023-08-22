
package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

import in.ineuron.utils.HibernateUtils;

public class RetrieveApp3 {

	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
				Query<Object[]> query = session.createQuery("SELECT pname,price FROM in.ineuron.model.Products WHERE pname IN(:prod1,:prod2)");				
				query.setParameter("prod1", "soap");
				query.setParameter("prod2", "hat");
				
				List<Object[]> products=query.list();
							
				System.out.println("Product\tPrice");
				products.forEach( row->{
								       for(Object obj:row)
								    	   System.out.print(obj+"\t");
								       System.out.println();
									   }
							    );				
				
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

