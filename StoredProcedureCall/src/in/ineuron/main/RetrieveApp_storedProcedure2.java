package in.ineuron.main;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.*;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp_storedProcedure2 {

	public static void main(String[] args) {
		
		Session session=null;
		int id=23;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
				ProcedureCall procedureCall = session.createStoredProcedureCall("getDetails",Products.class);
				
				procedureCall.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(id);
				procedureCall.registerParameter(2, String.class, ParameterMode.OUT);
				procedureCall.registerParameter(3, Integer.class, ParameterMode.OUT);
				procedureCall.registerParameter(4, Integer.class, ParameterMode.OUT);
				
				
				String pname=(String) procedureCall.getOutputParameterValue(2);
				Integer price=(Integer) procedureCall.getOutputParameterValue(3);
				Integer qty=(Integer) procedureCall.getOutputParameterValue(4);
				
				System.out.println("Id\tName\tPrice\tQty");
				System.out.println(id+"\t"+pname+"\t"+price+"\t"+qty);
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