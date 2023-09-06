package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.MobileCustomer;
import in.ineuron.utils.HibernateUtils;

public class client1 {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		MobileCustomer customer=null;
		
		boolean status=false;
		Long id=9905668976L;
		
		try {			
			session=HibernateUtils.getSession();
			
			if(session!=null) {	
				transaction = session.beginTransaction();
				
				if(transaction!=null) {
				
					customer = session.get(MobileCustomer.class, id);
					System.out.println(customer);
					System.out.println("I am sleeping....");
					Thread.sleep(30000);
						
					customer.setCallerTune("jina sirf tere liye .....");
					session.update(customer);
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
