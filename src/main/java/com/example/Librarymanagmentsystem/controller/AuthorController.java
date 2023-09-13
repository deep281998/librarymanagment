package com.example.Librarymanagmentsystem.controller;

import com.example.Librarymanagmentsystem.dtos.RequestDtos.AuthorReq;
import com.example.Librarymanagmentsystem.dtos.ResponseDtos.AuthorRespo;
import com.example.Librarymanagmentsystem.exception.AuthorNotFoundException;
import com.example.Librarymanagmentsystem.model.Author;
import com.example.Librarymanagmentsystem.model.Book;
import com.example.Librarymanagmentsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addauthor(@RequestBody AuthorReq author) {
        String response = authorService.addauthor(author);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateauthor(@RequestParam("id") int id , @RequestParam("email") String email){
        AuthorRespo author = authorService.updateauthor(id,email);
        if(author != null){
            return new ResponseEntity<>(author,HttpStatus.CREATED);
        }
        return new ResponseEntity<>("wrong id" , HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getall")
    public ResponseEntity getallbook(@RequestParam("id") int id){
        try {
            List<String> bookList = authorService.getallbook(id);
            return new ResponseEntity<>(bookList,HttpStatus.CREATED);
        }
        catch (AuthorNotFoundException e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}
