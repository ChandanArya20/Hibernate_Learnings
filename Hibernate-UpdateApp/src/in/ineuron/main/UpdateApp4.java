package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.Employee;
import in.ineuron.utils.HibernateUtils;

public class UpdateApp4 {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Employee employee=null;
		
		try {
			
			session=HibernateUtils.getSession();
			
			if(session!=null) 
				employee=session.get(Employee.class, 10);
				transaction=session.beginTransaction();
			if(transaction!=null) {	
				
				if(employee!=null) {
					
					System.out.println("Before updation in DB :: "+employee);
					System.in.read();
					
					session.refresh(employee);
					System.out.println("After updation in DB :: "+employee);
				}else
					System.out.println("Record not found...");										
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
