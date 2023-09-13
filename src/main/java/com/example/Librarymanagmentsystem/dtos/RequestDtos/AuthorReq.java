package com.example.Librarymanagmentsystem.dtos.RequestDtos;

import com.example.Librarymanagmentsystem.model.Book;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorReq {

    String name;

    int age;

    String email;

}
