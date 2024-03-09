package com.example.Librarymanagementsystemapplication.respository;

import com.example.Librarymanagementsystemapplication.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findByEmail(String email);
}
