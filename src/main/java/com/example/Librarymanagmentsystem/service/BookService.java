package com.example.Librarymanagmentsystem.service;

import com.example.Librarymanagmentsystem.exception.AuthorNotFoundException;
import com.example.Librarymanagmentsystem.model.Author;
import com.example.Librarymanagmentsystem.model.Book;
import com.example.Librarymanagmentsystem.repository.AuthorRepository;
import com.example.Librarymanagmentsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public String addbook(Book book) {
        Optional<Author> optionalAuthor = authorRepository.findById(book.getAuthor().getId());
        if(optionalAuthor.isEmpty()){
            throw new AuthorNotFoundException("Invalid author id");
        }
        Author author = optionalAuthor.get();
        book.setAuthor(author);
        author.getBookList().add(book);
        authorRepository.save(author);
        return "book added successfull";

    }
}
