package Decorator;

public abstract class NotifierDecorator implements Notifier {
	protected Notifier w;

    public NotifierDecorator(Notifier notifier) {
        this.w = notifier;
    }

    @Override
    public void send(String message) {
        w.send(message); 
    }
	

}
