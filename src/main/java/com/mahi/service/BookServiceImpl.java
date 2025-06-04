package com.mahi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mahi.model.Book;
import com.mahi.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;

    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book saveBook(Book book) {
    /*	book.setTitle("java");
    	book.setAuthor("Jk");*/
    	
        return bookRepo.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(Long id) {
    	
    	
        return bookRepo.findById(id)
                       .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }
    @Override
    public Book purchaseBook(Long id) {
        Book book = getBookById(id);
        book.setPurchased(true);
        return bookRepo.save(book);
    }

    @Override
    public boolean deleteBook(Long id) {
        bookRepo.deleteById(id);
		return false;
    }
}
