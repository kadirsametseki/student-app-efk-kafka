package com.example.microserviceapplication.exception;


import static com.example.microserviceapplication.exception.ErrorCodes.STUDENT_NOT_FOUND;

public class StudentNotFoundException extends GenericException{

    public StudentNotFoundException() {
        super(STUDENT_NOT_FOUND.getCode(), STUDENT_NOT_FOUND.getCode(), 404);
    }
}
