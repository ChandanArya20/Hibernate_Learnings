package in.ineuron.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.*;

import in.ineuron.model.Employee;
import in.ineuron.utils.HibernateUtils;

public class InsertApp {

	public static void main(String[] args) {
		
		Session session=null;
		boolean flag=false;
		
		try {			
			session=HibernateUtils.getSession();
			
			if(session!=null)
				session.beginTransaction();
			
//				Employee employee = new Employee();
//				employee.setEid(10);
//				employee.setEaddress("MI");
//				employee.setEname("sachin");
//	
//				employee.setFriendList(List.of("saurav", "dravid", "sehwagh"));
//				employee.setPhones(Set.of(99988877L,777666777L,555666777L));
//				employee.setBankAccounts(Map.of("SBI",112233L,"HDFC",223344L,"ICICI",112244L));
//				
//				session.save(employee);
				
				Employee employee1 = new Employee();
				employee1.setEid(12);
				employee1.setEaddress("Bettiah");
				employee1.setEname("Arya");
				
				employee1.setFriendList(List.of("Chandan", "Shivam", "Arjun"));
				employee1.setPhones(Set.of(9998567697L,9874446777L,7789540777L));
				employee1.setBankAccounts(Map.of("SBI",18789233L,"HDFC",45678344L,"ICICI",23456244L));
	
				session.save(employee1);

				flag=true;
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag)
				session.getTransaction().commit();
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
