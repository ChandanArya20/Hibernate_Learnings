package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;
import in.ineuron.model.Payment;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp {

	public static void main(String[] args) {
		
		Session session=null;
		boolean flag=false;
		
		try {			
			session=HibernateUtils.getSession();
			
			Query<Payment> query = session.createQuery("FROM in.ineuron.model.Payment");			
			List<Payment> list = query.list();		
			list.forEach(System.out::println);
			
			Query<CardPayment> query1 = session.createQuery("FROM in.ineuron.model.CardPayment");			
			List<CardPayment> list1 = query1.list();		
			list1.forEach(System.out::println);
			
			Query<ChequePayment> query2 = session.createQuery("FROM in.ineuron.model.ChequePayment");			
			List<ChequePayment> list2 = query2.list();		
			list2.forEach(System.out::println);
			

			
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
