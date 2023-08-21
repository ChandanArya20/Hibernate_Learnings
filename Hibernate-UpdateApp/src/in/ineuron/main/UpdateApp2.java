package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.Employee;
import in.ineuron.utils.HibernateUtils;

public class UpdateApp2 {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Employee employee=null;
		boolean status=false;
		
		try {
			
			session=HibernateUtils.getSession();
			
			if(session!=null) 
				employee=session.get(Employee.class, 10);
				transaction=session.beginTransaction();
			if(transaction!=null) {	
				
				if(employee!=null) {				
					employee.setSalary(20000);
					employee.setName("Ramu");
					status=true;
				}else
					System.out.println("Record not found...");										
			}						
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(status) {
				transaction.commit();
				System.out.println("Record updated successfully...");
				System.out.println(employee);
			}else {			
				transaction.rollback();
				System.out.println("Record not updatated...");
			}
			
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
