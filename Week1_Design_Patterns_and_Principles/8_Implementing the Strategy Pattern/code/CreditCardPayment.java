package strategypattern;

public class CreditCardPayment implements PaymentStrategy {
	 private String cardnum;
	    private String name;

	    public CreditCardPayment(String name, String cardnum) {
	        this.name = name;
	        this.cardnum = cardnum;
	    }
	    
	    @Override
	    public void pay(double amt) {
	        System.out.println("Paid $" + amt + " with Credit Card (" + cardnum + ") by " + name);
	    }
	

}
