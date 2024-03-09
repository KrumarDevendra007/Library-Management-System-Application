package com.example.Librarymanagementsystemapplication.entity;

import com.example.Librarymanagementsystemapplication.enums.Departments;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Departments department;
    private String mobileNo;
    private String email;
    @OneToOne(mappedBy = "student", cascade=CascadeType.ALL)
    Card card;
}
