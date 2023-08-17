package in.ineuron.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.*;

import in.ineuron.model.PersionalInfo;
import in.ineuron.utils.HibernateUtils;

public class SaveApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		
		boolean status=false;
		Integer id=null;
		
		try {
			
			session=HibernateUtils.getSession();
		
			if(session!=null) 
				transaction=session.beginTransaction();
			
			if(transaction!=null) {	
				PersionalInfo me=new PersionalInfo();
				me.setName("Chandan Kumar");
				me.setDob(LocalDateTime.of(2002,10,8,4,45));
				me.setDom(LocalDate.of(2026, 04, 10));
				me.setDoj(LocalTime.of(10, 35));
				
				id=(Integer) session.save(me);
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
				System.out.println();
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
