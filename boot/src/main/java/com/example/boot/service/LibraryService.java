package com.example.boot.service;

import com.example.boot.model.Book;
import com.example.boot.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Book findById(int id) {
        return libraryRepository.getById(id);
    }

    public void delete(int id) {
        libraryRepository.delete(findById(id));
    }

    public void createBook(Book book) {
        libraryRepository.save(book);
    }

    public List<Book> getAll() {
        return libraryRepository.findAll();
    }
}
