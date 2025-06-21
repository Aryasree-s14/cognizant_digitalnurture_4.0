package sortingorders;

public class Sorting {
	
	public static void bubbleSort(Order[] o)
	{
        int n = o.length;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (o[j].getPrice() < o[j + 1].getPrice()) 
                {
                    Order temp = o[j];
                    o[j] = o[j + 1];
                    o[j + 1] = temp;
                }
            }
        }
    }
	
	public static void quickSort(Order[] o, int l, int r) 
	{
        if (l < r) {
            int p = partition(o, l, r);
            quickSort(o, l, p - 1);
            quickSort(o, p + 1, r);
        }
    }

    private static int partition(Order[] o, int l, int r) 
    {
        double pivot = o[r].getPrice();
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (o[j].getPrice() >= pivot) {
                i++;
                Order temp = o[i];
                o[i] = o[j];
                o[j] = temp;
            }
        }
        
        Order temp = o[i + 1];
        o[i + 1] = o[r];
        o[r] = temp;

        return i + 1;
    }
}



