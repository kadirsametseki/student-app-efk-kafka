package com.example.microserviceapplication.service;

import com.example.microserviceapplication.dto.StudentResponse;
import com.example.microserviceapplication.dto.request.CreateStudentRequest;
import com.example.microserviceapplication.dto.request.UpdateStudentRequest;
import com.example.microserviceapplication.exception.StudentNotFoundException;
import com.example.microserviceapplication.mapper.StudentMapper;
import com.example.microserviceapplication.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public void createStudent(CreateStudentRequest request) {
        studentRepository.save(studentMapper.mapRequestToEntity(request));
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::mapEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        var student = studentRepository.findById(id)
                .orElseThrow(() -> exStudentNotFound(id));

        return studentMapper.mapEntityToResponse(student);
    }

    @Override
    public void updateStudent(Long id, UpdateStudentRequest request) {
        var student = studentRepository.findById(id)
                .orElseThrow(() -> exStudentNotFound(id));

        studentMapper.mapUpdateRequestToEntity(student, request);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        var student = studentRepository.findById(id)
                .orElseThrow(() -> exStudentNotFound(id));
        studentRepository.deleteById(student.getId());
    }

    public StudentNotFoundException exStudentNotFound(Long id) {
        throw new StudentNotFoundException("Student not found by id: " + id);
    }

}
