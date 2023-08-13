package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.Account;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp {

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
				
				session.evict(customer2);			//removing from L1-cache 
				
				Account customer3=session.get(Account.class, 1);
				System.out.println("3:: "+customer3);
				System.out.println("------------------------");//gets from L2-cache and put in L1-cache
				
				Account customer4=session.get(Account.class, 1);
				System.out.println("4:: "+customer4);
				System.out.println("------------------------");//gets from L1-cache
				
				
				
//				Account customer5=session.get(Account.class, 2);
//				System.out.println("5:: "+customer5);
//				System.out.println("------------------------");//gets from L1-cache
//				
//				session.clear();
//				
//				Account customer6=session.get(Account.class, 1);
//				System.out.println("6:: "+customer6);
//				System.out.println("------------------------");//gets from DB in L1-cache
//				
//				Account customer7=session.get(Account.class, 2);
//				System.out.println("7:: "+customer7);
//				System.out.println("------------------------");//gets from DB in L1-cache
//			
//				Account customer8=session.get(Account.class, 1);
//				System.out.println("8:: "+customer8);
//				System.out.println("------------------------");//gets from L1-cache
//							
//				Account customer9=session.get(Account.class, 2);
//				System.out.println("9:: "+customer9);
//				System.out.println("------------------------");//gets from L1-cache
//				
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
