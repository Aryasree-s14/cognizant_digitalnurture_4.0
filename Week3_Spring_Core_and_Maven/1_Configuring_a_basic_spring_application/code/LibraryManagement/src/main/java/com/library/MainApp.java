package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
    public static void main(String[] args) {
        System.out.println("Loading Spring Application Context");

        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("Spring Context Loaded Successfully");

        BookService bookService = (BookService) context.getBean("bookService");

        
        System.out.println("\n  Books Available  ");
        bookService.getAllBooks().forEach(System.out::println);
        

        
        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("Application finished.");
    }
}

