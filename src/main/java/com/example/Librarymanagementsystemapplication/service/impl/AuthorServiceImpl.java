package com.example.Librarymanagementsystemapplication.service.impl;

import com.example.Librarymanagementsystemapplication.dto.responseDto.AuthorResponseDto;
import com.example.Librarymanagementsystemapplication.entity.Author;
import com.example.Librarymanagementsystemapplication.respository.AuthorRepository;
import com.example.Librarymanagementsystemapplication.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author) {

        authorRepository.save(author);
        return "Author has been added";
    }

    @Override
    public AuthorResponseDto getAuthorByEmail(String email) {

        Author author = authorRepository.findByEmail(email);

         // prepare response Dto
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();

        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setEmail(author.getEmail());

        return authorResponseDto;

    }
}
