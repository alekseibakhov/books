package com.service;

import com.dao.BookDaoImpl;
import com.dao.DAOBookInterface;
import com.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class LibraryServiceImpl implements LibraryService {
    DAOBookInterface dao = new BookDaoImpl();

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Transactional
    @Override
    public List<Book> getLibrary() {
        return dao.getLibrary();
    }

    @Override
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }

    @Override
    public void createBook(Book book) {
        dao.createBook(book);
    }
}
