package com.example.Librarymanagmentsystem.service;

import com.example.Librarymanagmentsystem.dtos.RequestDtos.AuthorReq;
import com.example.Librarymanagmentsystem.dtos.ResponseDtos.AuthorRespo;
import com.example.Librarymanagmentsystem.exception.AuthorNotFoundException;
import com.example.Librarymanagmentsystem.model.Author;
import com.example.Librarymanagmentsystem.model.Book;
import com.example.Librarymanagmentsystem.repository.AuthorRepository;
import com.example.Librarymanagmentsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;


    public String addauthor(AuthorReq author) {
        Author author1 = new Author();
        author1.setName(author.getName());
        author1.setAge(author.getAge());
        author1.setEmail(author.getEmail());
        authorRepository.save(author1);
        return "Added successfully";
    }

    public AuthorRespo updateauthor(int id, String email) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()){
            AuthorRespo authorRespo = new AuthorRespo();
            authorRespo.setName(optionalAuthor.get().getName());
            authorRespo.setEmail(optionalAuthor.get().getEmail());

            return authorRespo;
        }
        return null;
    }

    public List<String> getallbook(int id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isEmpty()){
            throw new AuthorNotFoundException("Invalid id");
        }
        Author author = optionalAuthor.get();
        List<String> bookList = new ArrayList<>();
        for (Book book : author.getBookList()){
            bookList.add(book.getName());
        }
        return bookList;
    }
}
