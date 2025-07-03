package com.library.repository;

import java.util.List;

public class BookRepository {

   
    public BookRepository() {
        System.out.println("BookRepository instance created");
    }

    public List<String> findAllBooks() {
        
        return List.of("The Great Gatsby", "1984", "To Kill a Mockingbird", "Pride and Prejudice");
    }
}
