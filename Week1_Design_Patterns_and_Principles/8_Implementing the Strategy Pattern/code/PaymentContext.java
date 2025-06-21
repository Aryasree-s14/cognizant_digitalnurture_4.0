package strategypattern;

public class PaymentContext {
	
	 private PaymentStrategy s;

	    public void usePaymentStrategy(PaymentStrategy s) {
	        this.s = s;
	    }
	    
	    public void pay(double amt) {
	        if (s == null) {
	            System.out.println("payment strategy not selected");
	            return;
	        }
	        s.pay(amt);
	    }

}
