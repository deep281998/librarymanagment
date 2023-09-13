package com.example.Librarymanagmentsystem.controller;

import com.example.Librarymanagmentsystem.dtos.RequestDtos.StudentReq;
import com.example.Librarymanagmentsystem.dtos.ResponseDtos.StudentRespo;
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

    @PostMapping("/add")
    public ResponseEntity addstudent(@RequestBody StudentReq student){
        StudentRespo response = studentService.addstudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity getstudent(@RequestParam("id") int regNo){
        StudentRespo studentRespo = studentService.getstudent(regNo);
        if(studentRespo == null){
            return new ResponseEntity<>("Invalid id" , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentRespo,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deletestudent(@RequestParam("id") int regNo){
        String response = studentService.deletestudent(regNo);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity updateage(@RequestParam("id") int regNo , @RequestParam("age") int age){
        StudentRespo student = studentService.updateage(regNo , age);
        if(student != null) {
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Not found" , HttpStatus.NOT_FOUND);
    }
}
