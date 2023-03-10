package com.example.bookapplication.controller;

import com.example.bookapplication.entity.Book;
import com.example.bookapplication.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("com")
public class RestControllerNew {
    private BookService bookService;

    public RestControllerNew(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/book")
    public List<Book> getBook() {
        return bookService.getBook();

    }
    @PostMapping("/api/book")
    public Book addBook(@RequestBody Book book) {

        bookService.addBook(book);
        return book;
    }
    @PutMapping("/api/book")
    public Book updateBook(@RequestBody Book book) {

        bookService.updateBook(book);
        return book;

    }
    @DeleteMapping("/api/book")
    public String deleteBook(@RequestParam String isbn) {

        bookService.deleteBookByIsbn(isbn);
        return "Boor with isbn = " + isbn + " was deleted";

    }
}
