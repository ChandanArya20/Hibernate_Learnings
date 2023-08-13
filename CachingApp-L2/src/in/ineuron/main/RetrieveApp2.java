package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.Account;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp2 {

	public static void main(String[] args) {
		
		Session session=null;
		
		try {			
			session=HibernateUtils.getSession();
		
			if(session!=null) {	
				
				Account customer1=session.get(Account.class, 1);
				System.out.println("1:: "+customer1);
				System.out.println("------------------------");//gets from DB put in L2 and L1-cache
				
				Account customer2=session.get(Account.class, 1);
				System.out.println("2:: "+customer2);				
				System.out.println("------------------------");//gets from L1-cache
				
				session.evict(customer2);			//removing customer2 object from L1-cache 
				
				Account customer3=session.get(Account.class, 1);
				System.out.println("3:: "+customer3);
				System.out.println("------------------------");//gets from L2-cache and put in L1-cache
				
				session.clear(); 	//removing all object from L1-cache
				
				System.out.println("We are in sleeping mode....");
				Thread.sleep(20000);  // 10sec is idle time so object will be removed from L-2 cache
				
				Account customer4=session.get(Account.class, 1);
				System.out.println("4:: "+customer4);
				System.out.println("------------------------");//gets from DB and put L2-cache and L-1 cache
				
				
				

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
