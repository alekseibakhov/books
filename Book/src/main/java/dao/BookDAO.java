package dao;

import bd.Book;
import bd.ConnectionJDBC;
import bd.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.*;

import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.List;

public class BookDAO {
    ConnectionJDBC connectionJDBC = new ConnectionJDBC();


    public Book findById(int id) {
//        Book book= new Book();
//        try( Connection connection = connectionJDBC.getConnectionJDBC()) {
//            String sql = "SELECT * FROM book WHERE id = ?";
//            Statement statement1 = connection.createStatement();
//            statement1.execute(sql);
//
//            ResultSet set = statement1.getResultSet();
//            while (set.next()){
//
//            }

//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//
//            ResultSet resultSet = statement.executeQuery();
//            resultSet.next();
//                book.setTitle(resultSet.getString("title"));
//                book.setAuthor(resultSet.getString("author"));
//                book.setDate(resultSet.getInt("date"));
//                book.setGenre(resultSet.getString("genre"));
//                book.setNumOfPages(resultSet.getInt("numOfPages"));
//
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//        return book;
                return HibernateSessionFactory.getSessionFactory().openSession().get(Book.class, id);

    }

    public void save(Book book) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(book);
            tx1.commit();
        }
    }

    public void update(Book book) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(book);
            tx1.commit();
        }
    }

    public void delete(Book book) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(book);
            tx1.commit();
        }
    }

    public List<Book> findAll() {
        List<Book> book = (List<Book>)  HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Book").list();
        return book;
    }
}