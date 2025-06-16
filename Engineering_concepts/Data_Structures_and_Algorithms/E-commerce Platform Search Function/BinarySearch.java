package ecommercesearch;

public class BinarySearch
{
    public static Product search(Product[] products, String name)
    {
        int l = 0;
        int r = products.length - 1;

        while (l <= r) 
        {
            int mid = (l + r) / 2;
            int comp = products[mid].productName.compareTo(name); 

            if (comp == 0) 
            {
                return products[mid];
            } 
            else if (comp < 0) 
            {
                l = mid + 1;
            } 
            else
            {
                r = mid - 1;
            }
        }

        return null;
    }
}
