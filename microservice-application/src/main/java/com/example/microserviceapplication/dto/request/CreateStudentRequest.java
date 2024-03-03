package com.example.microserviceapplication.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest {
    @NotBlank(message = "Name must not be null")
    private String name;
    @NotBlank(message = "Surname must not be null")
    private String surname;
    @NotBlank(message = "Group name must not be null")
    private String groupName;
}
