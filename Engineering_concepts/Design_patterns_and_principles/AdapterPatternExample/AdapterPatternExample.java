package test;

import adapter.*;

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor pay = new Gpayadapter();
        pay.processPayment(60.0);

        PaymentProcessor p = new Paytmadapter();
        p.processPayment(50.0);
    }
}
