package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.MobileCustomer;
import in.ineuron.utils.HibernateUtils;

public class UpdateApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		MobileCustomer customer=null;
		
		boolean status=false;
		Long id=9905669732L;
		
		try {
			
			session=HibernateUtils.getSession();
			
			if(session!=null) {	
				
				customer = session.get(MobileCustomer.class, id);
				System.out.println("Loading the object :: " + customer);
				if(customer.getVersionCount()!=2) {
					
					transaction = session.beginTransaction();
					if(transaction!=null) {
						
//						customer.setCallerTune("rimjhim rimjhim.....");
//						customer.setCallerTune("teri kasam rimjhim.....");
						customer.setCallerTune("jina sirf tere liye .....");
						session.update(customer);
						status=true;																
					}
					
				}else
					System.out.println("You can't change the tune because you have already changed it two times in this month...");
					
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
				if(transaction!=null)
					transaction.rollback();
				System.out.println("Record not inserted...");
			}
			
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
