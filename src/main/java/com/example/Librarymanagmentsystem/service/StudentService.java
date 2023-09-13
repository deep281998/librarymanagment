package com.example.Librarymanagmentsystem.service;

import com.example.Librarymanagmentsystem.dtos.RequestDtos.StudentReq;
import com.example.Librarymanagmentsystem.dtos.ResponseDtos.StudentRespo;
import com.example.Librarymanagmentsystem.Enum.CardStatus;
import com.example.Librarymanagmentsystem.model.LibraryCard;
import com.example.Librarymanagmentsystem.repository.StudentRepository;
import com.example.Librarymanagmentsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentRespo addstudent(StudentReq student) {

        //create student entity using student request dtos
        Student newstudent = new Student();
        newstudent.setName(student.getName());
        newstudent.setAge(student.getAge());
        newstudent.setEmail(student.getEmail());
        newstudent.setGender(student.getGender());

        //auto generating the library card
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(newstudent);

        newstudent.setLibrarycard(libraryCard);

        Student savedstudent = studentRepository.save(newstudent);

        //return the student response
        StudentRespo studentRespo = new StudentRespo();
        studentRespo.setName(savedstudent.getName());
        studentRespo.setEmail(savedstudent.getEmail());
        studentRespo.setMessage("Id created successfully");
        studentRespo.setIssuedcardno(savedstudent.getLibrarycard().getCardNo());
        return studentRespo;


    }

    public StudentRespo getstudent(int regNo) {
        Optional<Student> studentOptional = studentRepository.findById(regNo);
        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            StudentRespo studentRespo = new StudentRespo();
            studentRespo.setName(student.getName());
            studentRespo.setEmail(student.getEmail());
            studentRespo.setMessage(student.getLibrarycard().getCardStatus().toString());
            studentRespo.setIssuedcardno(student.getLibrarycard().getCardNo());
            return studentRespo;
        }
        return null;
    }

    public String deletestudent(int regNo) {
        Optional<Student> studentOptional = studentRepository.findById(regNo);
        if(studentOptional.isPresent()){
            studentRepository.deleteById(regNo);
            return "Deleted successfully";
        }
        return "Not found";
    }

    public StudentRespo updateage(int regNo, int age) {
        Optional<Student> optionalStudentdtos = studentRepository.findById(regNo);
        if(optionalStudentdtos.isPresent()){
            Student student = optionalStudentdtos.get();
            student.setAge(age);
            studentRepository.save(student);

            StudentRespo studentRespo = new StudentRespo();
            studentRespo.setName(optionalStudentdtos.get().getName());
            studentRespo.setEmail(optionalStudentdtos.get().getEmail());
            studentRespo.setMessage(optionalStudentdtos.get().getLibrarycard().getCardStatus().toString());
            studentRespo.setIssuedcardno(optionalStudentdtos.get().getLibrarycard().getCardNo());
            studentRespo.setAge(age);
            return studentRespo;

        }
        return null;
    }
}
