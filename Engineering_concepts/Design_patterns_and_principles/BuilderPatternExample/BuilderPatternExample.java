package test;
import builder.Computer;
public class BuilderPatternExample {
	 public static void main(String[] args) {
	        Computer comp1 = new Computer.Builder()
	                .cpu("i5").ram("8GB").storage("512GB").build();

	        Computer comp2 = new Computer.Builder()
	                .cpu("i7").ram("32GB").storage("1TB").build();

	        System.out.println("Computer 1 specifications:");
	        comp1.specifications();
	        System.out.println("Computer 2 Specifications:");
	        comp2.specifications();
}
}
