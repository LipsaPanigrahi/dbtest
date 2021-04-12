package hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TradeSelect {

	public void selectTrade() {
		SessionFactory sessionFactory = HibernateUtils.hibernateDetails();
		//System.out.println(sessionFactory.getCurrentSession());
		  //getting session object from session factory
		  Session session = sessionFactory.openSession();
		  //getting transaction object from session object
		  session.beginTransaction();
		  Query query = session.createQuery(" from hibernate.Trade");
		  List<Trade> trades = query.list();
		  for(Trade t : trades)
		  {
		System.out.println(t.toString());
		  }
		  session.getTransaction().commit();
		  sessionFactory.close();
		
	}
	
	public static void main(String[] args) {
		TradeSelect hibernate = new TradeSelect();
		hibernate.selectTrade();
	}
	
}
