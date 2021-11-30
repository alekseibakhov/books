//package com.dao;
//
//import com.model.Book;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Component
//@Repository
//public class BookDAOImpl implements BookDAO {
//    private SessionFactory sessionFactory;
//
//    public BookDAOImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public void delete(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(session.load(Book.class, id));
//    }
//
//    public List<Book> getLibrary() {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("from Book").list();
//    }
//
//    public Book getBookById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(Book.class, id);
//    }
//
//    public void createBook(Book book) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(book);
//    }
//
//}
