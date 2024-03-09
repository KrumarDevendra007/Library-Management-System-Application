package com.example.Librarymanagementsystemapplication.dto.responseDto;

import com.example.Librarymanagementsystemapplication.entity.Card;
import com.example.Librarymanagementsystemapplication.enums.Departments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponseDto {
    private int id;
    private String name;
    private int age;
    private Departments department;
    private String mobileNo;
    private String email;
    CardResponseDto cardResponseDto;
}
