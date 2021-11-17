package dao;

import bd.Book;

import java.util.List;

public interface DAO {
    Book getBook(String name);
    List<Book> getBook();


    Book getBookById(int id);


    void addBook(Book book);


    void deleteBook(int id);
}
