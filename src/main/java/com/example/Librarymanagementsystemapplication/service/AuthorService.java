package com.example.Librarymanagementsystemapplication.service;

import com.example.Librarymanagementsystemapplication.dto.responseDto.AuthorResponseDto;
import com.example.Librarymanagementsystemapplication.entity.Author;

public interface AuthorService {

    public String addAuthor(Author author);
    public AuthorResponseDto getAuthorByEmail(String email);
}
