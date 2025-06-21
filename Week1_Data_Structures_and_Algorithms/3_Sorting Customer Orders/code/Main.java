package sortingorders;

public class Main {

	public static void main(String[] args) {
		Order[] orders = {
	            new Order("1", "Ana", 300),
	            new Order("2", "Bill", 60),
	            new Order("3", "Carl", 400),
	            new Order("4", "Dan", 200)
	        };
		System.out.println("Initial Orders:");
        for (Order o : orders) {
            System.out.println(o);
        }
        
        System.out.println("\nSorted result using bubble sort:");
        Sorting.bubbleSort(orders);
        for (Order o : orders) {
            System.out.println(o);
        }
        
        orders = new Order[]{
                new Order("1", "Ana", 300),
                new Order("2", "Bill", 60),
                new Order("3", "Carl", 400),
                new Order("4", "Dan", 200)
            };
        
        System.out.println("\nSorted result using quick sort:");
        Sorting.quickSort(orders, 0, orders.length - 1);
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
		
	


