package dao;

import bd.Book;

import java.util.List;

public class DAOImplLibrary implements DAO {
    private BookDAO bookDAO = new BookDAO();

    @Override
    public Book getBook(String name) {
        return null;
    }

    @Override
    public List<Book> getBook() {
        return bookDAO.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    public void addBook(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDAO.delete(bookDAO.findById(id));
    }
}
