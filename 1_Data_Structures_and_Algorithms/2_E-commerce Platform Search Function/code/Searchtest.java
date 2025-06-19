package ecommercesearch;

public class Searchtest 
{
    public static void main(String[] args) 
    {
        Product[] products = 
        	{
            new Product(1, "Mobile", "Electronics"),
            new Product(2, "Dress", "Fashion"),
            new Product(3, "Bag", "Accessories")
            
        };

        System.out.println("Linear Search:");
        Product result1 = LinearSearch.search(products, "Bag");
        System.out.println(result1 != null ? result1 : "Not found");
        
        sortProducts(products);

        System.out.println("Binary Search:");
        Product result2 = BinarySearch.search(products, "Bag");
        System.out.println(result2 != null ? result2 : "Not found");
    }
        public static void sortProducts(Product[] products) 
        {
            for (int i = 0; i < products.length - 1; i++)
            {
                for (int j = 0; j < products.length - i - 1; j++) 
                {
                    if (products[j].productName.compareTo(products[j + 1].productName) > 0)
                    {
                        Product temp = products[j];
                        products[j] = products[j + 1];
                        products[j + 1] = temp;
                    }
                }
            }
    }
}
