package com.mahi.service;

import java.util.List;

import com.mahi.model.Book;
public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    boolean deleteBook(Long id);
}
