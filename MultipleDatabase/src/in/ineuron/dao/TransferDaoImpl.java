package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils1;
import in.ineuron.utils.HibernateUtils2;

public class TransferDaoImpl implements ITransferDao{

	@SuppressWarnings("finally")
	@Override
	public String transferProduct(Integer id) {
		Session session1=HibernateUtils1.getSession();
		Session session2=HibernateUtils2.getSession();
		Transaction trans=null;
		
		Boolean status=false;		
		
		Products product=session1.get(Products.class,id);
		if(product==null)
			return "Record not available for transfer....";
		else {
			
			try {
				trans=session2.beginTransaction();
				if(trans!=null) {
					
					session2.save(product);
					status=true;
				}
			} catch (Exception e) {
				return "somethings went wrong..., Product not transfered....";
				
			}finally {
				
				if(status) { 
					trans.commit();
					return "Product copied from mydb database to studentproject database with id : "+id;
				}else {
					trans.rollback();
					return "Product not copied from mydb database to studentproject database with id : "+id;

				}
			}
		}		
		
	}
	
}
