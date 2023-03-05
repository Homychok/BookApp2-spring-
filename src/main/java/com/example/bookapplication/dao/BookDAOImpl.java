package com.example.bookapplication.dao;

import com.example.bookapplication.entity.Book;
import com.example.bookapplication.service.BookRowService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;
@Repository
public class BookDAOImpl implements BookDAO {
    private JdbcTemplate template;

    public BookDAOImpl(@Lazy JdbcTemplate template) {
        this.template = template;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Override
    public void addBook(Book book) {
        template.update("INSERT INTO book VALUES (?, ?, ?, ?)",
                book.getBookName(), book.getBookAuthor(), book.getBookYear(), book.getIsbn());
//        Session session = sessionFactory.getCurrentSession();
//        session.save(book);
    }
    @Override
    public void updateBook(Book book) {
        template.update("UPDATE book SET 'Название книги' = ?, 'Автор книги' = ?, " +
                        "'Год издания книги' = ? WHERE isbn = ?",
book.getBookName(), book.getBookAuthor(), book.getBookYear(), book.getIsbn());
//        Session session = sessionFactory.getCurrentSession();
//        session.update(bookName, bookAuthor);
//        session.update(bookYear);

    }

    @Override
    public void deleteBookByIsbn(String isbn) {
        template.update("DELETE FROM book WHERE isbn = ?", isbn);
    }
//    @Override
//
//    public void delete(int isbn) {

//        Session session = sessionFactory.getCurrentSession();
//        org.hibernate.query.Query<Book> query = session.createQuery("delete from Book where isbn=:isbn");
//        query.setParameter("isbn", isbn);
//        query.executeUpdate();
//    }
    @Override
    public Book getBookByIsbn(String isbn) {
        return template.query("SELECT * FROM book WHERE isbn = ?",
                new Object[] {isbn},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(Book.class, isbn);    }
@Override
    public List<Book> getBook() {
        return template.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("From Book").list();
    }



}
