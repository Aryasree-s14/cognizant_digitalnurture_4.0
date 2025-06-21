package observer;

public class WebApp implements Observer{
	private String s;

    public WebApp(String s) {
        this.s = s;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println("Web App " + s + " Stock price is: $" + stockPrice);
    }
}


