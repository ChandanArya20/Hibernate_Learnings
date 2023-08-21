package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils;

public class UpdateApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction = null;
		int count=0;
		boolean flag=false;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) 				
				transaction = session.beginTransaction();
			if(transaction!=null) {
				
				// Prepare Query object to hold HQL
				Query query = session.
						createQuery("UPDATE in.ineuron.model.Products SET qty=qty+:newQty WHERE pname LIKE :initialLetter");				
				
				query.setParameter("newQty", 10);
				query.setParameter("initialLetter", "f%");
				
				//executing the query
				count=query.executeUpdate();
				flag=true;			
				
			}						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("No of rows affected is :: " + count);
			}else {
				transaction.rollback();
				System.out.println("No of rows affected is :: " + count);
			}
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}