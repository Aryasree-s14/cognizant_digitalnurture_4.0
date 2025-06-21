package observer;

public class MobileApp implements Observer {
	private String u;

    public MobileApp(String u) {
        this.u = u;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println("Mobile App user -" + u + " Stock price :$" + stockPrice);
    }
}


