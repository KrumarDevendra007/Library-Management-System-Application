package com.example.Librarymanagementsystemapplication.respository;

import com.example.Librarymanagementsystemapplication.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
