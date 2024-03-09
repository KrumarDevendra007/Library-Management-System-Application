package com.example.Librarymanagementsystemapplication.service.impl;

import com.example.Librarymanagementsystemapplication.dto.requestDto.IssueBookRequestDto;
import com.example.Librarymanagementsystemapplication.dto.responseDto.IssueBookResponseDto;
import com.example.Librarymanagementsystemapplication.entity.Book;
import com.example.Librarymanagementsystemapplication.entity.Card;
import com.example.Librarymanagementsystemapplication.entity.Transaction;
import com.example.Librarymanagementsystemapplication.enums.CardStatus;
import com.example.Librarymanagementsystemapplication.enums.TransactionStatus;
import com.example.Librarymanagementsystemapplication.respository.BookRepository;
import com.example.Librarymanagementsystemapplication.respository.CardRepository;
import com.example.Librarymanagementsystemapplication.respository.TransactionRepository;
import com.example.Librarymanagementsystemapplication.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOpration(true);

          Card card;
          try{
              card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
          }
          catch (Exception e){
              transaction.setTransactionStatus(TransactionStatus.FAILED);
              transactionRepository.save(transaction);
              throw new Exception("Invalid card ID!");
          }

          transaction.setCard(card);

          Book book;
          try {
              book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
          }
          catch (Exception e){
              throw new Exception("Invalid book ID!");
          }

         transaction.setBook(book);

          if(card.getCardStatus() != CardStatus.ACTIVATED){
              transaction.setTransactionStatus(TransactionStatus.FAILED);
              transactionRepository.save(transaction);
              throw new Exception("Card is not Active!!");
          }

          if(book.isIssued() == true){
              transaction.setTransactionStatus(TransactionStatus.FAILED);
              transactionRepository.save(transaction);
              throw new Exception("Book is not available");
          }

          transaction.setTransactionStatus(TransactionStatus.SUCCESS);
          book.setIssued(true);
          book.setCard(card);
          book.getTransactionList().add(transaction);

          card.getBookIssued().add(book);
          card.getTransactionList().add(transaction);

          cardRepository.save(card);

          //prepare response dto;
         IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
         issueBookResponseDto.setBookName(book.getTitle());
         issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());
         issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());

         String text = "Congrats! " + card.getStudent().getName() +" You hava issued the book " + book.getTitle();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("frontierx5432@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Book issued successfully");
        message.setText(text);
        emailSender.send(message);

         return issueBookResponseDto;

    }

    // return book API
}
