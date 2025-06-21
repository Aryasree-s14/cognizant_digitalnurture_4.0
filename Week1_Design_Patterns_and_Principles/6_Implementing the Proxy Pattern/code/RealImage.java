package proxypattern;

public class RealImage implements Image{
	 private String name;

	    public RealImage(String name) {
	        this.name = name;
	        load();
	    }

	    private void load() {
	        System.out.println("Loading image" + name);
	    }

	    @Override
	    public void display() {
	        System.out.println("Displaying image: " + name);
	    }
	}


