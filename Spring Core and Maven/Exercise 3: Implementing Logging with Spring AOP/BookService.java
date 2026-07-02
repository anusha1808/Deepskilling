package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService(){
        System.out.println("Book service");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Dependency injected");
    }

    public void addBook(String title){
        System.out.println("Adding book: " + title);
    }

    public String getBook(String id){
        return "Book: " + id;
    }
}
