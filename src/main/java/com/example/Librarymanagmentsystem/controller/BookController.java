package com.example.Librarymanagmentsystem.controller;

import com.example.Librarymanagmentsystem.model.Book;
import com.example.Librarymanagmentsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity addbook(@RequestBody Book book){
        String response = bookService.addbook(book);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
