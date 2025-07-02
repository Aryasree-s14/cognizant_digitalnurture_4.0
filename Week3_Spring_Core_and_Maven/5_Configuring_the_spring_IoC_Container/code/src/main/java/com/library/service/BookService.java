package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

  
    public BookService() {
        System.out.println("BookService instance created (default constructor)");
    }

    
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected into BookService via setter");
    }

    
    public List<String> getAllBooks() {
        if (bookRepository == null) {
            System.err.println("Error: BookRepository was not injected into BookService");
           
            return List.of("Error: Book repository not available.");
        }
        System.out.println("Fetching all books via BookService...");
        return bookRepository.findAllBooks();
    }
}
