package in.ineuron.main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

import in.ineuron.dao.TransferProductDaoImpl;
import in.ineuron.model.Products;
import in.ineuron.utils.HibernateUtils;

public class TransferApp {

	public static void main(String[] args) {
		
		TransferProductDaoImpl transDao = new TransferProductDaoImpl();
		String msg=transDao.transferProduct(50);
		System.out.println(msg);
		
	}
}