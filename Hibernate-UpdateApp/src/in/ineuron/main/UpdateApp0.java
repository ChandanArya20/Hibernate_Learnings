package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.Employee;
import in.ineuron.utils.HibernateUtils;

public class UpdateApp0 {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Employee employee=null;
		boolean status=false;
		
		try {
			
			session=HibernateUtils.getSession();
			if(session!=null) 
				transaction=session.beginTransaction();
			if(transaction!=null) {	
				
				employee=new Employee();
				employee.setId(10);
				employee.setName("Sagar");
				employee.setAddress("Mumbai");
				employee.setSalary(10000);
				
				session.update(employee);
				status=true;				
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
