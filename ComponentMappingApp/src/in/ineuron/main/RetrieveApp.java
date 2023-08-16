package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

import in.ineuron.model.Address;
import in.ineuron.model.Person;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp {

	public static void main(String[] args) {
		
		Session session=null;
		boolean flag=false;
		
		try {			
			session=HibernateUtils.getSession();
			
			Query<Person> query = session.createQuery("FROM in.ineuron.model.Person WHERE city=:city");
			query.setParameter("city", "Patna");
			
			List<Person> list = query.list();
			
			list.forEach(person->System.out.println(person.getAddress().getCountry()));
			
//			System.out.println(list);
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
