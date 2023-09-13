package com.example.Librarymanagmentsystem.dtos.ResponseDtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRespo {

    String name;

    String email;

    String message;

    String issuedcardno;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer age;
}

