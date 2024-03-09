package com.example.Librarymanagementsystemapplication.respository;

import com.example.Librarymanagementsystemapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
