package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;


public class BookService {

    private BookRepository bookRepository;

    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService instance created with BookRepository");
    }

   
    public List<String> getAllBooks() {
        System.out.println("Fetching all books via BookService");
        return bookRepository.findAllBooks();
    }
}

