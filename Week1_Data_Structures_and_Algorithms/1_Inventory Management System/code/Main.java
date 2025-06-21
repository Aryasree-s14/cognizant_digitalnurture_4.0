package inventorymanagement;

public class Main {

	public static void main(String[] args)
	{
		InventoryManager m = new InventoryManager();
		m.addProduct(new Product("01", "PC", 30, 1256.00));
        m.addProduct(new Product("02", "Speaker", 50, 300.00));
        m.addProduct(new Product("03", "Keyboard", 10, 490.00));
        m.display();
        m.updateProduct("03", "Wireless keyboard", 40, 690.00);
        m.deleteProduct("02");
        m.display();
	}

}
