package com.example.Librarymanagementsystemapplication.dto.requestDto;

import com.example.Librarymanagementsystemapplication.enums.Departments;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentRequestDto {
    private  String name;
    private int age;
    private Departments department;
    private String mobileNo;
    private String email;
}
