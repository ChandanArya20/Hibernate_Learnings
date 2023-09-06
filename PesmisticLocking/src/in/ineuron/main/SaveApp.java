package in.ineuron.main;

import org.hibernate.*;
import in.ineuron.model.MobileCustomerCenter;
import in.ineuron.utils.HibernateUtils;

public class SaveApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		MobileCustomerCenter customer=null;
		
		boolean status=false;
		Long id=null;
		
		try {
			
			session=HibernateUtils.getSession();
		
			if(session!=null) 
				transaction=session.beginTransaction();
			
			if(transaction!=null) {	
				customer=new MobileCustomerCenter();
				
				customer.setMobileNo(9905668976L);
				customer.setCname("Dhoni");
				customer.setCallerTune("ab..aba.....");
				
				id= (Long)session.save(customer);
				status=true;				
			}						
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(status) {
				transaction.commit();
				System.out.println("Record inserted successfully with id : "+id);
				System.out.println(customer);
			}
			else {			
				transaction.rollback();
				System.out.println("Record not inserted...");
			}
			
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
