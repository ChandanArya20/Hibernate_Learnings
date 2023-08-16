package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.ProgrammerProjId;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.utils.HibernateUtils;

public class GetApp {

	public static void main(String[] args) {
		
		Session session=null;
		ProgrammerProjId id=null;
		
		try {
			
			session=HibernateUtils.getSession();
		
			if(session!=null) {
				
				id=new ProgrammerProjId();
				id.setpId(100);
				id.setProjId(501);
				
				ProgrammerProjInfo prgInfo=session.get(ProgrammerProjInfo.class, id);
				
				if(prgInfo!=null)
					System.out.println(prgInfo);
				else
					System.out.println("Record not found for the id : "+id);
								
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
