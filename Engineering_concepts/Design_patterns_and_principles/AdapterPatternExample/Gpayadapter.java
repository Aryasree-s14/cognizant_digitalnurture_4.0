package adapter;

public class Gpayadapter implements PaymentProcessor {
	 private GooglePay pay = new GooglePay();

	    public void processPayment(double amt) {
	        pay.gpay(amt);
	    }
	}


