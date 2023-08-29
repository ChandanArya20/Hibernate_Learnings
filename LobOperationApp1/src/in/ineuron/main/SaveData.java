package in.ineuron.main;

import java.io.*;

import org.hibernate.*;
import in.ineuron.model.JobSeeker;
import in.ineuron.utils.HibernateUtils;

public class SaveData {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		JobSeeker js=null;
		
		Integer id=1234;
		boolean status=false;
		byte[] photo=null;
		char[] resume=null;
			
		
		try {
			
			session=HibernateUtils.getSession();
		
			if(session!=null) 
				transaction=session.beginTransaction();
			
			if(transaction!=null) {	
				
				File f=new File("C:\\Users\\Chandan\\Downloads\\Test\\mePhoto.jpg");
				FileInputStream fis=new FileInputStream(f);
				photo=new byte[(int) f.length()];
				fis.read(photo);
				
				f=new File("C:\\Users\\Chandan\\Downloads\\Test\\cssCheatSheet.pdf");
				FileReader fr=new FileReader(f);
				resume=new char[(int) f.length()];
				fr.read(resume);
				
				js=new JobSeeker();
				js.setId(id);
				js.setName("Chandan");
				js.setAddress("Bettiah");
				js.setPhoto(photo);
				js.setResume(resume);
				
				id=(Integer) session.save(js);
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
