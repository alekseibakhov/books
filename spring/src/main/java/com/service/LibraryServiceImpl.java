package com.service;

import com.model.Book;
import com.repository.LibraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository dao;

    public LibraryServiceImpl(LibraryRepository dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(dao.getById(id));
    }

    @Transactional
    @Override
    public List<Book> getLibrary() {
        return dao.findAll();
    }

    @Transactional
    @Override
    public Book getBookById(int id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void createBook(Book book) {
        dao.save(book);
    }
}
