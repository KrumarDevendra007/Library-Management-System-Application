package com.example.Librarymanagementsystemapplication.respository;

import com.example.Librarymanagementsystemapplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
