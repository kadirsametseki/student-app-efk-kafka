package com.example.microserviceapplication.repository;

import com.example.microserviceapplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
