package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
        System.out.println("Book Service Created");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Dependency injected");
    }

    public void addBook(String bookName){
        System.out.println("Added book: " + bookName);
    }

    public String getBook(int id){
        bookRepository.findById(id);
        return "Book found!";
    }
}
