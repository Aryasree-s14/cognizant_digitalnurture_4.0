package singleton;

public class Main {

	public static void main(String[] args) {
		Logger Logger1= Logger.getInstance();
		Logger1.log("first message");
		Logger Logger2= Logger.getInstance();
		Logger2.log("second message");
		
		if (Logger1==Logger2)
		{
			System.out.println("Same Instances");
			
		}
		else
		{
			System.out.println("Different Instances");
		}

	}

}
