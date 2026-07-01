package com.library.service;

import com.library.repository.BookRepository;

import java.awt.print.Book;

public class BookService {

    private BookRepository bookRepository;

    public BookService(){
        System.out.println("Book service");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Dependency injected");
    }
}
