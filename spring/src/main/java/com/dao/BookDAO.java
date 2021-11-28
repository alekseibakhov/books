package com.dao;

import com.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookDAO implements DAOBookInterface {
    int id;
    List<Book> list;

    {
        list  = new ArrayList<>();
        list.add(new Book(++id, "title", "genre", "author", 1900, 500));
        list.add(new Book(++id, "title2", "genre2", "author2", 1901, 501));
        list.add(new Book(++id, "title3", "genre3", "author3", 1902, 502));
    }
    public void delete(int id){
        list.remove(id);
    }
    public List<Book> getLibrary(){return list;}
    public Book getBookById(int id){return list.stream().filter(book -> book.getId() == id).findAny().orElse(null);}
    public void createBook(Book book){
        book.setId(++id);
        list.add(book);
    }

}
