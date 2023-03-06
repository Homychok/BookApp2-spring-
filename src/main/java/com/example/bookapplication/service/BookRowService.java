package com.example.bookapplication.service;


import com.example.bookapplication.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowService implements RowMapper<Book> {
//    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book newBook = new Book();
        newBook.setBookName(rs.getString("book_name"));
        newBook.setBookAuthor(rs.getString("book_author"));
        newBook.setBookYear(rs.getInt("book_year"));
        newBook.setIsbn(rs.getString("isbn"));
        return newBook;
    }
}
