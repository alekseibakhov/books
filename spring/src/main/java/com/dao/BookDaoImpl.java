package com.dao;

import com.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public class BookDaoImpl implements DAOBookInterface {

    public void delete(int id) {
//        dao.delete(dao.findById(id));

    }

    public List<Book> getLibrary() {
//        return dao.findAll();
        return null;
    }

    public Book getBookById(int id) {
//        return dao.findById(id);
        return null;

    }

    public void createBook(Book book) {
//        dao.save(book);
    }

}