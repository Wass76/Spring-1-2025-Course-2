package com.training.LearningManagmentSystem.teacher;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherResponse {

    private Integer id;
    private String firstName;
    private String lastName;

}
