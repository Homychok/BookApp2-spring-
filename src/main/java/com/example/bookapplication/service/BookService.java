package com.example.bookapplication.service;


import com.example.bookapplication.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBook();
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBookByIsbn(String isbn);
}
