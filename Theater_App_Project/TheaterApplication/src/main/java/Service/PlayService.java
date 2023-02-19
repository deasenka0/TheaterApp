package Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entity.Play;
import Util.HibernateUtil;

public class PlayService {

	public List<Play> getAllPlays(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<Play> list = new ArrayList<Play>();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			String sql = "from Play ";
			Query query = session.createQuery(sql);
			list = query.list();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
	
	public Play  getPlayById(long id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Play play = new Play();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			play = (Play)session.get(Play.class, id);
			trans.commit();
		}catch (Exception e) {
			
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return play;
	}
}
