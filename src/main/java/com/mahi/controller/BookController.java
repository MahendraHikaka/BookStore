package com.mahi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mahi.model.Book;
import com.mahi.service.BookService;
@CrossOrigin
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Add book
    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.ok(savedBook);
    }


    // Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // Get book by ID
    @GetMapping("/find")
    public ResponseEntity<Book> getBook(@RequestParam("id") Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Delete book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        boolean isDeleted = bookService.deleteBook(id);
        if (isDeleted) {
            return ResponseEntity.ok("Book deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found with ID: " + id);
        }
    }
    //Buy end point
    @PutMapping("/buy/{id}")
    public Book purchaseBook(@PathVariable Long id) {
        return bookService.purchaseBook(id);
    }
}
