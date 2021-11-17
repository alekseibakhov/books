package dao;

import bd.Book;
import bd.LibraryClass;

import java.util.List;

public class DAOImplLibrary implements DAO {
    List<Book> list = LibraryClass.getClassLibrary().getLibrary();

    @Override
    public Book getBook(String name) {
        return null;
    }

    @Override
    public List<Book> getBook() {
        return list;
    }

    @Override
    public Book getBookById(int id) {
        return list.get(id);
    }

    @Override
    public void addBook(Book book) {
        list.add(book);
    }

    @Override
    public void deleteBook(int id) {
        list.remove(id);
    }
}
