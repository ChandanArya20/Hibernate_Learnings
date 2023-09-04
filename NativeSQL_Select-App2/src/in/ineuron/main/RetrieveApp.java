package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp {

	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
//				NativeQuery<Products> query = session.createSQLQuery("SELECT * FROM products WHERE qty>=?");
				NativeQuery<Products> query = session.createSQLQuery("SELECT * FROM products WHERE qty>=:value");
				query.setParameter("value", 20);
				
				query.addEntity(Products.class);
				
				List<Products> resultList = query.getResultList();
				
				resultList.forEach(System.out::println);
				
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