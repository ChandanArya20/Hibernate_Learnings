package in.ineuron.main;

import java.time.LocalDate;

import org.hibernate.*;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;
import in.ineuron.utils.HibernateUtils;

public class InsertApp {

	public static void main(String[] args) {
		
		Session session=null;
		boolean flag=false;
		
		try {			
			session=HibernateUtils.getSession();
			
			if(session!=null)
				session.beginTransaction();
			
			CardPayment cardPayment = new CardPayment();
			cardPayment.setPid(1234);
			cardPayment.setAmount(8000.5f);
			cardPayment.setCardNo(45678L);
			cardPayment.setCardType("Debit");
			cardPayment.setPaymentGateway("visa");

			
			ChequePayment chequePayment = new ChequePayment();
			chequePayment.setPid(1235);
			chequePayment.setAmount(4500.56f);
			chequePayment.setChequeNo(546345L);
			chequePayment.setChequeType("self");
			chequePayment.setExpriyDate(LocalDate.of(23, 4, 27));

			session.save(cardPayment);
			session.save(chequePayment);

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
