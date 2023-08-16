package in.ineuron.main;

import org.hibernate.*;

import in.ineuron.model.Address;
import in.ineuron.model.Person;
import in.ineuron.utils.HibernateUtils;

public class InsertApp {

	public static void main(String[] args) {
		
		Session session=null;
		boolean flag=false;
		
		try {			
			session=HibernateUtils.getSession();
			
			if(session!=null)
				session.beginTransaction();
			
			Address address = new Address();
			address.setCountry("Indai");
			address.setCity("Patna");
			address.setPincode(845307);
			
			Person person = new Person();
			person.setName("Chandan");
			person.setAge(21);
			person.setAddress(address);
			
			Address address1 = new Address();
			address1.setCountry("Indai");
			address1.setCity("Delhi");
			address1.setPincode(765489);
			
			Person person1 = new Person();
			person1.setName("Arya");
			person1.setAge(23);
			person1.setAddress(address1);
			
			session.save(person1);
			session.save(person);
			
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
