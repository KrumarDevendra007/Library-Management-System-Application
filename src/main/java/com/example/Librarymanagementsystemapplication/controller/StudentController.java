package com.example.Librarymanagementsystemapplication.controller;


import com.example.Librarymanagementsystemapplication.dto.requestDto.StudentMobUpdateRequestDto;
import com.example.Librarymanagementsystemapplication.dto.requestDto.StudentRequestDto;
import com.example.Librarymanagementsystemapplication.dto.responseDto.StudentMobUpdateResponseDto;
import com.example.Librarymanagementsystemapplication.dto.responseDto.StudentResponseDto;
import com.example.Librarymanagementsystemapplication.exception.StudentNotFountException;
import com.example.Librarymanagementsystemapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

      @Autowired
      StudentService studentService;

      @PostMapping("/add")
      public String addStudent(@RequestBody StudentRequestDto studentRequestDto){

            return  studentService.addStudent(studentRequestDto);
      }

      @PutMapping("/update_mobile")
      public StudentMobUpdateResponseDto updateMobNo(@RequestBody StudentMobUpdateRequestDto studentMobUpdateRequestDto) throws StudentNotFountException {
            return studentService.updateMobile(studentMobUpdateRequestDto);
      }


      // delete a student by id

      // update the student by id

      // find a student by id
      @GetMapping("/get_student")
      public StudentResponseDto getStudent(@RequestParam("id") int id) throws Exception {
            return studentService.getStudentById(id);
      }

      // find all the student
}
