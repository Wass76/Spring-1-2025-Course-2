package com.training.LearningManagmentSystem.teacher;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TeacherRequest {

    @NotEmpty(message = "firstName should not be empty")
    private String firstName;
    @NotEmpty(message = "lastName should not be empty")
    private String lastName;

}
