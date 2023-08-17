package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.NativeQuery;

import com.mysql.cj.x.protobuf.MysqlxCrud.Projection;

import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils;

public class RetrieveApp2 {

	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtils.getSession();
			if(session!=null) {
				
				Criteria criteria = session.createCriteria(Products.class);
				
				ProjectionList list = Projections.projectionList();
				list.add(Projections.property("pname"));
				list.add(Projections.property("qty"));
				
				criteria.setProjection(list);
				
				Criterion cond1 = Restrictions.ge("price",50);
				Criterion cond2=Restrictions.le("price",100);
				
				criteria.add(cond1);
				criteria.add(cond2);
				
				Order order = Order.asc("pname");				
				criteria.addOrder(order);
				
				List<Object[]> proList=criteria.list();
				
				proList.forEach(row->{
					for(Object obj:row) {
						System.out.print(obj+"\t");
					}
					System.out.println();
				});
				
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