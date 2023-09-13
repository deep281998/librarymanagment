package com.example.Librarymanagmentsystem.dtos.ResponseDtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorRespo {

    String name;

    String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Book> bookList = new ArrayList<>();
}
