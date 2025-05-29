package com.mahi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahi.model.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
}
