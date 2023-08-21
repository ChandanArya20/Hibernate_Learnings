package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.utils.HibernateUtils;

public class TransferProductDaoImpl implements TransferProductDao {

	@Override
	public String transferProduct(Integer minPrice) {
		
		Session session=null;
		Transaction transaction = null;
		int count=0;
		boolean flag=false;
		String msg="";
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) 				
				transaction = session.beginTransaction();
			if(transaction!=null) {
				
				// Prepare Query object to hold HQL
				Query query = session.getNamedQuery("HQLTransferQuery");				
				
				query.setParameter("minPrice", minPrice);
				
				//executing the query
				count=query.executeUpdate();
				flag=true;			
				
			}						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {			
			if(flag) {
				transaction.commit();
				msg="No of rows affected is :: " + count;
			}else {
				transaction.rollback();
				msg="No of rows affected is :: " + count;
			}
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();			
		}
		return msg;
		
	}
	

}
