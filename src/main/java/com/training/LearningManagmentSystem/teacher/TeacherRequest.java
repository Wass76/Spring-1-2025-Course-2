package com.training.LearningManagmentSystem.teacher;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeacherRequest {

    @NotNull(message = "firstName should not be null")
    @NotEmpty(message = "firstName should not be empty")
    private String firstName;
    @NotNull(message = "lastName should not be null")
    @NotEmpty(message = "lastName should not be empty")
    private String lastName;




}
