package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.BankAccount;
import in.ineuron.utils.HibernateUtils;


public class SaveApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		BankAccount customer=null;
		
		boolean status=false;
		Long id=null;
		
		try {
			System.out.println("Krishna");
			session=HibernateUtils.getSession();
			
			if(session!=null) 
				transaction=session.beginTransaction();
			
			if(transaction!=null) {	
				customer=new BankAccount();
				
				customer.setHolderName("Chandan");
				customer.setBalance(2000);
				customer.setAccountType("saving");
				
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
			}
			else {	
				if(transaction!=null)
					transaction.rollback();
				System.out.println("Record not inserted...");
			}
			
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
