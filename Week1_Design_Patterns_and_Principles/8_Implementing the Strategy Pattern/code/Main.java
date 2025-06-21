package strategypattern;

public class Main {

	public static void main(String[] args) {
		
		PaymentContext c = new PaymentContext();

        c.usePaymentStrategy(new CreditCardPayment("Emma", "12345678"));
        c.pay(300.00);

        
        c.usePaymentStrategy(new PayPalPayment("ema23@gmail.com"));
        c.pay(800.0);
	}

}
