package com.example.Librarymanagmentsystem.model;

import com.example.Librarymanagmentsystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String CardNo;

    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    @CreatedDate
    Date issuedate;

    @OneToOne
    @JoinColumn
    Student student;


}
