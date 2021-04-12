package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TradeCreate {
	
	public void createTrade(Trade t){
	SessionFactory sessionFactory = HibernateUtils.hibernateDetails();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(t);  
	    tx.commit();  
	    System.out.println("successfully saved");    
	    sessionFactory.close();  
	    session.close(); 
	}
	
	
}
