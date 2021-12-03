package com.example.boot.repository;

import com.example.boot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Book, Integer> {
}
