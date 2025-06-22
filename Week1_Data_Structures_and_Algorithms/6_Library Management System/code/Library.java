package librarysystem;

import java.util.*;
public class Library {
	
	 static class Book {
	        int bookId;
	        String title;
	        String author;

	        public Book(int bookId, String title, String author)
	        {
	            this.bookId = bookId;
	            this.title = title;
	            this.author = author;
	        }
	        
	        public String toString() {
	            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
	        }
	    }
	 
	 public static Book linearSearch(List<Book> books, String title)
	 {
	        for (Book b : books)
	        {
	            if (b.title.equalsIgnoreCase(title)) 
	            {
	                return b;
	            }
	        }
	        return null;
	    }
	 
	 public static Book binarySearch(List<Book> books, String title)
	 {
	        int l = 0;
	        int r = books.size() - 1;

	        while (l <= r) 
	        {
	            int mid = (l+ r) / 2;
	            int comparison = books.get(mid).title.compareToIgnoreCase(title);

	            if (comparison == 0)
	            {
	                return books.get(mid);
	            } 
	            else if (comparison < 0) 
	            {
	                l = mid + 1;
	            }
	            
	            else {
	                r = mid - 1;
	            }
	        }

	        return null;
	 }
	 
	 public static void main(String[] args) {
	        List<Book> books = new ArrayList<>();
	        
	        books.add(new Book(1, "The Alchemist", "Paulo Coelho"));
	        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
	        books.add(new Book(3, "Palace of Illusions", "Chitra Banerjee"));
	        books.add(new Book(4, "Pride and Prejudice", "Jane Austen"));
	        
	        System.out.println("Linear Search:");
	        Book r1 = linearSearch(books, "The Alchemist");
	        if (r1 != null) 
	        {
	            System.out.println("Book Found: " + r1);
	        } 
	        else 
	        {
	            System.out.println("Book not found");
	        }
	        
	        books.sort(Comparator.comparing(b -> b.title.toLowerCase()));
	        
	        System.out.println("Binary Search:");
	        Book r2 = binarySearch(books, "Palace of Illusions");
	        if (r2 != null)
	        {
	            System.out.println("Book Found: " + r2);
	        }
	        else 
	        {
	            System.out.println("Book not found");
	        }
	 }
}

	        
	        

	 
	 
	
	


