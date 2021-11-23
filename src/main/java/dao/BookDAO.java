package dao;

import bd.Book;
import bd.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.*;

import java.util.List;

public class BookDAO {

    public Book findById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Book.class, id);
    }

    public void save(Book book) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(book);
        tx1.commit();
        session.close();
    }

    public void update(Book book) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(book);
        tx1.commit();
        session.close();
    }

    public void delete(Book book) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(book);
        tx1.commit();
        session.close();
    }

    public List<Book> findAll() {
        List<Book> book = (List<Book>)  HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Book").list();
        return book;
    }
}