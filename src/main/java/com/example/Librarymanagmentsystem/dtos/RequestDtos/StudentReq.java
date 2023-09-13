package com.example.Librarymanagmentsystem.dtos.RequestDtos;

import com.example.Librarymanagmentsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentReq {

    String name;

    int age;

    String email;

    Gender gender;
}
