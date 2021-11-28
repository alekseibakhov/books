package com.dao;

import com.model.Book;

import java.util.List;

public interface DAOBookInterface {
    void delete(int id);
    List<Book> getLibrary();
    Book getBookById(int id);
    void createBook(Book book);
}
