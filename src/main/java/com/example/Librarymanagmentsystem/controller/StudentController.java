package com.example.Librarymanagmentsystem.controller;

import com.example.Librarymanagmentsystem.model.Student;
import com.example.Librarymanagmentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addstudent")
    public ResponseEntity addstudent(@RequestBody Student student){
        String response = studentService.addstudent(student);
        return new ResponseEntity(response , HttpStatus.CREATED);
    }
}
