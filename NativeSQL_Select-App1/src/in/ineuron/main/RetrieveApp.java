package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.NativeQuery;

import in.ineuron.utils.HibernateUtils;

public class RetrieveApp {

	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
				NativeQuery<Object[]> query = session.createSQLQuery("SELECT * FROM products WHERE qty>=?");
				query.setParameter(1, 20);
				
				List<Object[]> resultList = query.getResultList();
				
				resultList.forEach(row->{
										for(Object obj:row) {
											System.out.print(obj+"\t");
										}	
										System.out.println();
									});
				
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