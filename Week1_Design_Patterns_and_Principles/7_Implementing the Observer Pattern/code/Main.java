package observer;

public class Main {

	public static void main(String[] args) {
		
		 StockMarket sm = new StockMarket();

	        Observer mobile = new MobileApp("Jack");
	        Observer web = new WebApp("stockprices.com");
	        sm.register(mobile);
	        sm.register(web);
	        sm.setStockPrice(200);
	        sm.setStockPrice(300);

	        sm.deregister(mobile);

	        sm.setStockPrice(160);

	}

}
