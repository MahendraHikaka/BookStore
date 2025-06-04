package com.mahi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mahi.repository.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
    public static void main(String[] args) {
       SpringApplication.run(BookstoreApplication.class, args);
       
       System.out.println("Successfully it is working :");
     
    }
}
