package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.ProgrammerProjId;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.utils.HibernateUtils;

public class SaveApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		ProgrammerProjId id=null;
		ProgrammerProjInfo prgInfo=null;
		boolean status=false;
		
		try {
			
			session=HibernateUtils.getSession();
		
			if(session!=null) 
				transaction=session.beginTransaction();
			
			if(transaction!=null) {	
				
				id=new ProgrammerProjId();
				id.setpId(100);
				id.setProjId(501);
				
				prgInfo=new ProgrammerProjInfo();
				prgInfo.setId(id);
				prgInfo.setpName("Sachin");
				prgInfo.setDeptNo(10);
				
				id=(ProgrammerProjId)session.save(prgInfo);
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
				System.out.println(prgInfo);
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
