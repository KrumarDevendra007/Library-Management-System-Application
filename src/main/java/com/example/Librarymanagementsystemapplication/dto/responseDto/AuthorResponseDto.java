package com.example.Librarymanagementsystemapplication.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorResponseDto {

    private String name;
    private int age;
    private String email;
}
