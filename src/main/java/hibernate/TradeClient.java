package hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TradeClient {
	
	public static void main(String[] args) {
	      
	       SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	       Date maturityDate;
		try {
			maturityDate = sdf.parse("20/08/2020");
		
	       Date createdDate = new Date(System.currentTimeMillis());
	       		Trade t1 = new Trade("T1",1,"CP-1","B1",maturityDate,createdDate,'N');
				Trade t2 = new Trade("T2",1,"CP-2","B2",maturityDate,createdDate,'Y');
				Trade t3 = new Trade("T3",3,"CP-3","B3",maturityDate,createdDate,'Y');
				Trade t4 = new Trade("T4",4,"CP-4","B4",maturityDate,createdDate,'Y');
				
				TradeCreate c = new TradeCreate();
				c.createTrade(t4);
				TradeUpdate tradeUpdate = new TradeUpdate();
				tradeUpdate.updateRow(t2);
				
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				    
	}

}
