package com.example.Librarymanagementsystemapplication.controller;

import com.example.Librarymanagementsystemapplication.entity.Book;
import com.example.Librarymanagementsystemapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception {

        return bookService.addBook(book);
    }

    // find all book

    //find all the number of book written by an author

    // find the number of book written by an author
}
