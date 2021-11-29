package com.service;

import com.model.Book;

import java.util.List;

public interface LibraryService {
    void delete(int id);
    List<Book> getLibrary();
    Book getBookById(int id);
    void createBook(Book book);
}
