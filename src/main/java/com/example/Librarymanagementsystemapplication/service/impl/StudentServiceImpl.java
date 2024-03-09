package com.example.Librarymanagementsystemapplication.service.impl;

import com.example.Librarymanagementsystemapplication.dto.requestDto.StudentMobUpdateRequestDto;
import com.example.Librarymanagementsystemapplication.dto.requestDto.StudentRequestDto;
import com.example.Librarymanagementsystemapplication.dto.responseDto.CardResponseDto;
import com.example.Librarymanagementsystemapplication.dto.responseDto.StudentMobUpdateResponseDto;
import com.example.Librarymanagementsystemapplication.dto.responseDto.StudentResponseDto;
import com.example.Librarymanagementsystemapplication.entity.Card;
import com.example.Librarymanagementsystemapplication.entity.Student;
import com.example.Librarymanagementsystemapplication.enums.CardStatus;
import com.example.Librarymanagementsystemapplication.exception.StudentNotFountException;
import com.example.Librarymanagementsystemapplication.respository.StudentRepository;
import com.example.Librarymanagementsystemapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobileNo(studentRequestDto.getMobileNo());
        student.setEmail(studentRequestDto.getEmail());


        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2025-01-03");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        return "Student has been added";
    }

    @Override
    public StudentResponseDto getStudentById(int id) throws Exception {

        Student student;

        try{
            student = studentRepository.findById(id).get();
        }
        catch (Exception e){
            throw new Exception("Student not found! please enter correct ID");
        }

        //prepare response
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setMobileNo(student.getMobileNo());
        studentResponseDto.setEmail(student.getEmail());

        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setId(student.getCard().getId());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setUpdateOn(student.getCard().getUpDatedOn());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setValidTill(student.getCard().getValidTill());

        studentResponseDto.setCardResponseDto(cardResponseDto);

        return studentResponseDto;

    }

    @Override
    public StudentMobUpdateResponseDto updateMobile(StudentMobUpdateRequestDto studentMobUpdateRequestDto) throws StudentNotFountException {


        try {
            Student student = studentRepository.findById(studentMobUpdateRequestDto.getId()).get();
            student.setMobileNo(studentMobUpdateRequestDto.getMobileNo());
            Student updatedStudent = studentRepository.save(student);

            // prepare response dto
            StudentMobUpdateResponseDto studentMobUpdateResponseDto = new StudentMobUpdateResponseDto();
            studentMobUpdateResponseDto.setName(updatedStudent.getName());
            studentMobUpdateResponseDto.setMobileNo(updatedStudent.getMobileNo());

            return studentMobUpdateResponseDto;

        }
        catch (Exception e){
            throw new StudentNotFountException("Student not present! Please enter correct Student ID");
        }
    }
}
