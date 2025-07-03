package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List; 

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Starting Library Management Application...");
        System.out.println("Loading Spring Application Context from 'applicationContext.xml'...");

     
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("Spring Context Loaded Successfully");

        
        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("\n  Books Available in the Library ");
        List<String> books = bookService.getAllBooks();
        books.forEach(System.out::println);
        

        
        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("Application finished and Spring Context closed.");
    }
}
