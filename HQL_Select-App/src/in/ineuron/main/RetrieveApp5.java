
package in.ineuron.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.query.Query;

import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp5 {

	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
				Query<Products> query = session.createQuery("FROM in.ineuron.model.Products WHERE pid=:id");	
				
				System.out.println("Enter the id for product to be fetched : ");
				Integer id=new Scanner(System.in).nextInt();
				query.setParameter("id", id);
				
				List<Products> product=query.getResultList();
							
				if(!product.isEmpty()) {
					System.out.println(product.get(0));
				}else
					System.out.println("Data not found for the id :"+id);
								
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

