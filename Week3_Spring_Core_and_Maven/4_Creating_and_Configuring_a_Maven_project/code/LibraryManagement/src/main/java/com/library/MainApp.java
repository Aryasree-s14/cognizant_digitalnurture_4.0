package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List; 

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Starting LibraryManagement Application");
        System.out.println("Attempting to load Spring Application Context");

       
        System.out.println("Hello from LibraryManagement!");
        System.out.println("Project setup successful");

        
        List<String> messages = List.of("Message 1", "Message 2");
        System.out.println("Messages: " + messages);

        
        System.out.println("Application finished.");
    }
}
