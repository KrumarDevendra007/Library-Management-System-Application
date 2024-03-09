package com.example.Librarymanagementsystemapplication.controller;

import com.example.Librarymanagementsystemapplication.dto.responseDto.AuthorResponseDto;
import com.example.Librarymanagementsystemapplication.entity.Author;
import com.example.Librarymanagementsystemapplication.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
       return authorService.addAuthor(author);
    }

    @GetMapping("/get_author_by_email")
    public AuthorResponseDto getAuthorByEmail(@RequestParam("email")String email){
        return authorService.getAuthorByEmail(email);
    }

    //get all the author nof particular age
}
