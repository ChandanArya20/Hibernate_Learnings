package in.ineuron.main;

import in.ineuron.dao.ITransferDao;
import in.ineuron.dao.TransferDaoImpl;
import in.ineuron.utils.HibernateUtils1;
import in.ineuron.utils.HibernateUtils2;

public class MultipleDatabases {

	public static void main(String[] args) {
		
		ITransferDao dao=new TransferDaoImpl();
		String result=dao.transferProduct(1002);
		System.out.println(result);
		
		HibernateUtils1.closeSessionFactory();
		HibernateUtils2.closeSessionFactory();
		
	}
}







