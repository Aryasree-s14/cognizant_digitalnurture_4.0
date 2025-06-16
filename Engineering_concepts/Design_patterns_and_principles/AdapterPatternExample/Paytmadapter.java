package adapter;

public class Paytmadapter implements PaymentProcessor {
	 private Paytm p = new Paytm();

	    public void processPayment(double amt) {
	        p.payt(amt);
	    }
	}

