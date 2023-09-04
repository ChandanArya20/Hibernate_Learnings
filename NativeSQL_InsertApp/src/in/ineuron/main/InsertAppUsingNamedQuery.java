package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils;

public class InsertAppUsingNamedQuery {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		int rowAffected=0;
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
				transaction=session.beginTransaction();
				
				NativeQuery query = session.getNamedNativeQuery("insert-query");
				
				query.setParameter(1, "Brush");
				query.setParameter(2, 30);
				query.setParameter(3, 50);
				
				rowAffected = query.executeUpdate();				
				flag=true;
				
			}						
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("Data inserted ....."+rowAffected);
			}else {
				transaction.rollback();
				System.out.println("Data inserted ....."+rowAffected);
			}
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}