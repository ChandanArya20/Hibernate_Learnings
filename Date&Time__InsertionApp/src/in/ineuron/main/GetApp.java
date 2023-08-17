package in.ineuron.main;

import org.hibernate.*;
import in.ineuron.model.PersionalInfo;
import in.ineuron.utils.HibernateUtils;

public class GetApp {

	public static void main(String[] args) {
		
		Session session=null;
		PersionalInfo me=null;
		Integer id=1;
		
		try {			
			session=HibernateUtils.getSession();		
			if(session!=null) {
				
				me=session.get(PersionalInfo.class, id);
				if(me!=null)
					System.out.println(me);
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
