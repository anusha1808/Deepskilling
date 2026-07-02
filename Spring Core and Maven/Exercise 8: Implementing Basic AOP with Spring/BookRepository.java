package com.library.repository;


public class BookRepository {
    public BookRepository(){
        System.out.println("Book Repository created");
    }

    public void findById(int id){
        System.out.println("Book with id: " + id);
    }
}
