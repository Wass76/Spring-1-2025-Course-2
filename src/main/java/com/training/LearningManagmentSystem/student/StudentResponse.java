package com.training.LearningManagmentSystem.student;

import com.training.LearningManagmentSystem.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long studentId;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer mark;
    private Long course;
    private List<Integer> teachers;
}
