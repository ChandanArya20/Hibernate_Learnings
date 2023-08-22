package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp {

	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
				// Prepare Query object to hold HQL

				Query<Products> query = session.createQuery("FROM in.ineuron.model.Products");				
				
				//executing the query
				List<Products> products=query.list();
							
				//process the list objects
				products.forEach(System.out::println);				
				
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