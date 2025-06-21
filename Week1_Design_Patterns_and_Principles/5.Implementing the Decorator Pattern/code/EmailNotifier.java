package Decorator;

public class EmailNotifier implements Notifier {

	@Override
    public void send(String msg) {
        System.out.println("Sending an email: " + msg);
    }
}
