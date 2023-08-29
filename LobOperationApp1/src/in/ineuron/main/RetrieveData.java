package in.ineuron.main;

import java.io.*;
import org.hibernate.*;
import in.ineuron.model.JobSeeker;
import in.ineuron.utils.HibernateUtils;

public class RetrieveData {

	public static void main(String[] args) {
		
		Session session=null;
		JobSeeker jskr=null;
		
		boolean status=false;
		Integer id=1234;
		
		try {			
			session=HibernateUtils.getSession();			
			if(session!=null)
				jskr=session.get(JobSeeker.class, id);
			if(jskr!=null) {
				
				try(FileOutputStream fos=new FileOutputStream("C:\\Users\\Chandan\\Desktop\\Test\\image.png");
						FileWriter fr=new FileWriter("C:\\Users\\Chandan\\Desktop\\Test\\resume.pdf")){
					
					fos.write(jskr.getPhoto());
					fr.write(jskr.getResume());
					
					System.out.println("Photo and resume got downloaded....");
					
				}
				
			}else
				System.out.println("Data not found for the id : "+id);		
									
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
