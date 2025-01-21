package com.training.LearningManagmentSystem.course;

import com.training.LearningManagmentSystem.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @OneToMany
    private List<Student> students;
}
