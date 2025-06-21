package inventorymanagement;

import java.util.HashMap;

public class InventoryManager 
{
    private HashMap<String, Product> inventory;

    public InventoryManager() 
    {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) 
    {
        inventory.put(product.getProductId(), product);
        System.out.println("product added: " + product);
    }

    public void updateProduct(String productId, String name, int quantity, double price) 
    {
        Product p = inventory.get(productId);
        if (p != null) 
        {
            p.setProductName(name);
            p.setQuantity(quantity);
            p.setPrice(price);
            System.out.println("Inventory Updated: " + p);
        } 
        else 
        {
            System.out.println("Product not found");
        }
    }

    public void deleteProduct(String productId) 
    {
        Product removed = inventory.remove(productId);
        if (removed != null) 
        {
            System.out.println("product deleted: " + removed);
        }
        else 
        {
            System.out.println("Product not found");
        }
    }

    public void display() 
    {
        System.out.println("\nPresent Inventory:");
        for (Product product : inventory.values())
        {
            System.out.println(product);
        }
    }
}
