package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp {

	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
				Criteria criteria = session.createCriteria(Products.class);
				
				Criterion cond1 = Restrictions.ge("price",50);
				Criterion cond2=Restrictions.le("price",100);
				
				criteria.add(cond1);
				criteria.add(cond2);
				
				List<Products> proList=criteria.list();
				
				proList.forEach(System.out::println);
				
				Order order = Order.asc("price");
				
				criteria.addOrder(order);
				
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