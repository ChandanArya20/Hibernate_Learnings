package in.ineuron.main;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.*;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp_storedProcedure {

	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
				ProcedureCall procedureCall = session.createStoredProcedureCall("getDetails",Products.class);
				
				procedureCall.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(23);
				
				
				List<Products> products = procedureCall.getResultList();
				
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