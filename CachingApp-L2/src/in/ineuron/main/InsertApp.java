package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.Account;
import in.ineuron.utils.HibernateUtils;

public class InsertApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Account customer=null;
		
		boolean status=false;
		Integer id=null;
		
		try {			
			session=HibernateUtils.getSession();
			if(session!=null) 
				transaction=session.beginTransaction();
			
			if(transaction!=null) {	
				customer=new Account();
				customer.setHolderName("Chandan");
				customer.setBalance(5000);
				
				id= (Integer) session.save(customer);
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
