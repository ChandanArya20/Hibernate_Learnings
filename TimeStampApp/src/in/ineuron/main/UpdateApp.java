package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.BankAccount;
import in.ineuron.utils.HibernateUtils;

public class UpdateApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		BankAccount customer=null;
		
		boolean status=false;
		Long id=9905669732L;
		
		try {			
			session=HibernateUtils.getSession();			
			if(session!=null)
				transaction=session.beginTransaction();
			if(transaction!=null) {
				
				customer = session.get(BankAccount.class, id);
				System.out.println("Loading the object :: " + customer);
				if(customer!=null) {
					
					customer.setBalance(customer.getBalance()+5000);
					status=true;
					
				}
			}
											
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(status) {
				transaction.commit();
				System.out.println("Record updated successfully with id : "+id);
				System.out.println(customer);
			}
			else {		
				if(transaction!=null)
					transaction.rollback();
				System.out.println("Record not updated...");
			}
			
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
