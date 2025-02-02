package com.training.LearningManagmentSystem.student;

import lombok.Data;

import java.util.List;

@Data
public class StudentRequest {
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer mark;
    private Long course;
    private List<Integer> teacherId;
}
