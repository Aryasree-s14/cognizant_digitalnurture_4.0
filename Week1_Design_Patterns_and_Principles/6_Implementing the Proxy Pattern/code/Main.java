package proxypattern;

public class Main {

	public static void main(String[] args) {
		
		Image i1 = new ProxyImage("pic1.jpg");
        Image i2 = new ProxyImage("pic2.jpg");
        
        System.out.println("show pic1.jpg");
        i1.display();
        
        System.out.println("\n show pic2.jpg");
        i2.display();
       
		

	}

}
