package observer;
import java.util.List;
import java.util.ArrayList;
public class StockMarket implements Stock {
	
	private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyobservers() {
        for (Observer o : observers) {
            o.update(stockPrice);
        }
    }

    
    public void setStockPrice(double price) {
        System.out.println("\nStock price updated to: $" + price);
        this.stockPrice = price;
        notifyobservers();
    }
}


