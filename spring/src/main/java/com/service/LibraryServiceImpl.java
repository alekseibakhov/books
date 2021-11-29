package com.service;

import com.dao.BookImpl;
import com.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final BookImpl dao;

    public LibraryServiceImpl(BookImpl dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Transactional
    @Override
    public List<Book> getLibrary() {
        return dao.getLibrary();
    }

    @Transactional
    @Override
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }

    @Transactional
    @Override
    public void createBook(Book book) {
        dao.createBook(book);
    }
}
