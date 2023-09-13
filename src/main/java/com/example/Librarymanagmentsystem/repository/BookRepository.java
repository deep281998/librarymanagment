package com.example.Librarymanagmentsystem.repository;

import com.example.Librarymanagmentsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book , Integer> {
}
