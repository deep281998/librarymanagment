package com.example.Librarymanagmentsystem.repository;

import com.example.Librarymanagmentsystem.model.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author , Integer> {
}
