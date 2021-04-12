package hibernate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TradeUpdate {

	public void updateTrade(){
		 SessionFactory sessionFactory = HibernateUtils.hibernateDetails();
		  //getting session object from session factory
		  Session session = sessionFactory.openSession();
		  //getting transaction object from session object
		  session.beginTransaction();
		  Query query = session.createQuery("from hibernate.Trade");
		  List<Trade> trades = query.list();
		  for(Trade t : trades)
		  {
		  if(t.getMaturityDate().before(t.getCreatedDate()))
		  t.setExpired('Y');
		  System.out.println("Updated Successfully");
		  }
		  session.getTransaction().commit();
		  sessionFactory.close();
		}
	
	public void updateRow(Trade t){
		SessionFactory sessionFactory = HibernateUtils.hibernateDetails();
		  //getting session object from session factory
		  Session session = sessionFactory.openSession();
		  //getting transaction object from session object
		  session.beginTransaction();
		  Query query = session.createQuery("from hibernate.Trade");
		  List<Trade> trades = query.list();
		  Iterator<Trade> setVersion = trades.iterator();
		  Set<Integer> setTrade = new HashSet<Integer>();
		
		  	for(Trade t1 : trades){
		  		
		  		if(t1.getVersion() == t.getVersion())
		  			t1.setBookId(t.getBookId());
		  		t1.setCounterPartyId(t.getCounterPartyId());
		  		t1.setTradeId(t.getTradeId());
		  		t1.setCreatedDate(t.getCreatedDate());
		  		t1.setMaturityDate(t.getMaturityDate());
		  		t1.setExpired(t.getExpired());
		  		session.saveOrUpdate(t1);
		  		session.getTransaction().commit();
		  		System.out.println("Updated Successfully");
		  }
		  	sessionFactory.close();
		  	}

	public static void main(String[] args) {
		TradeUpdate tradeUpdate = new TradeUpdate();
		tradeUpdate.updateTrade();
		
	}
}
