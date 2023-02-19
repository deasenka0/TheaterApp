package Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entity.CustomerAccount;
import Util.HibernateUtil;

public class CustomerAccountService {

	public CustomerAccount getCustomerAccountByUsername(String username) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		CustomerAccount customerAccount = new CustomerAccount();
		Session session = null;
		try {
			List<CustomerAccount> list = new ArrayList<CustomerAccount>();
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			String sql = "from CustomerAccount where username = '"+username+"' ";
			Query query = session.createQuery(sql);
			list = query.list();
			if(list != null && list.size() > 0){
				customerAccount = list.get(0);
			}
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return customerAccount;
	}

	public void saveCustomerAccount(CustomerAccount newCustomerAccount) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(newCustomerAccount);
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
