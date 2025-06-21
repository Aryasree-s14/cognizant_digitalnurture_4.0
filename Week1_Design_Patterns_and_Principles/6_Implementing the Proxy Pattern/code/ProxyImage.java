package proxypattern;

public class ProxyImage implements Image{
	private RealImage r;
    private String name;

    public ProxyImage(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        if (r == null) {
            r = new RealImage(name); 
        }
        r.display();

    }
}
