package com.example.Librarymanagmentsystem.service;

import com.example.Librarymanagmentsystem.Enum.CardStatus;
import com.example.Librarymanagmentsystem.model.LibraryCard;
import com.example.Librarymanagmentsystem.repository.StudentRepository;
import com.example.Librarymanagmentsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addstudent(Student student) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibrarycard(libraryCard);  // set librarycard for student
        Student savedStudent = studentRepository.save(student); // save both student and library card
        return "Student saved successfully";
    }
}
