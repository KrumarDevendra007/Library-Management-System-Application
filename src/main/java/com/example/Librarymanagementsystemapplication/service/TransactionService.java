package com.example.Librarymanagementsystemapplication.service;

import com.example.Librarymanagementsystemapplication.dto.requestDto.IssueBookRequestDto;
import com.example.Librarymanagementsystemapplication.dto.responseDto.IssueBookResponseDto;

public interface TransactionService {

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
