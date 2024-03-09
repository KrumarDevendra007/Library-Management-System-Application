package com.example.Librarymanagementsystemapplication.service;

import com.example.Librarymanagementsystemapplication.dto.requestDto.StudentMobUpdateRequestDto;
import com.example.Librarymanagementsystemapplication.dto.requestDto.StudentRequestDto;
import com.example.Librarymanagementsystemapplication.dto.responseDto.StudentMobUpdateResponseDto;
import com.example.Librarymanagementsystemapplication.dto.responseDto.StudentResponseDto;
import com.example.Librarymanagementsystemapplication.exception.StudentNotFountException;


public interface StudentService {

    public String addStudent(StudentRequestDto studentRequestDto);

    public StudentResponseDto getStudentById(int id) throws Exception;
    public StudentMobUpdateResponseDto updateMobile(StudentMobUpdateRequestDto studentMobUpdateRequestDto) throws StudentNotFountException;
}
