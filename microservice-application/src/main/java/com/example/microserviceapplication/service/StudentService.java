package com.example.microserviceapplication.service;

import com.example.microserviceapplication.dto.StudentResponse;
import com.example.microserviceapplication.dto.request.CreateStudentRequest;
import com.example.microserviceapplication.dto.request.UpdateStudentRequest;
import com.example.microserviceapplication.model.Student;

import java.util.List;

public interface StudentService {

    void createStudent(CreateStudentRequest request);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long id);

    void updateStudent(Long id, UpdateStudentRequest request);

    void deleteStudent(Long id);
}
