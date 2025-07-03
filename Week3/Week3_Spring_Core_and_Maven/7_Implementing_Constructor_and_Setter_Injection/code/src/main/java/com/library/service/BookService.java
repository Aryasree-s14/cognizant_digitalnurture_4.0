package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {

    private String libraryName; 
    private BookRepository bookRepository; 

    public BookService(String libraryName) {
        this.libraryName = libraryName;
        System.out.println("BookService instance created with library name: " + libraryName + " (Constructor Injection)");
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
        System.out.println("Fetching all books for " + libraryName + " via BookService");
        return bookRepository.findAllBooks();
    }
}
