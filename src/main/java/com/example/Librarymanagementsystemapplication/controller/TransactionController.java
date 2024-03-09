package com.example.Librarymanagementsystemapplication.controller;

import com.example.Librarymanagementsystemapplication.dto.requestDto.IssueBookRequestDto;
import com.example.Librarymanagementsystemapplication.dto.responseDto.IssueBookResponseDto;
import com.example.Librarymanagementsystemapplication.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public IssueBookResponseDto issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {

           return transactionService.issueBook(issueBookRequestDto);
    }

}
