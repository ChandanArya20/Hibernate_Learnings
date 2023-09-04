package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp2 {

	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
				NativeQuery<Object[]> query = session.createSQLQuery("SELECT pname,qty FROM products WHERE qty>=:value");
				query.setParameter("value", 20);
				
				query.addScalar("pname", StandardBasicTypes.STRING);
				query.addScalar("qty", StandardBasicTypes.INTEGER);
				
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