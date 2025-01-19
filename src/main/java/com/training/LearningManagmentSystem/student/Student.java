package com.training.LearningManagmentSystem.student;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "STUDENTS")
public class Student {
    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    private String lastName;
    private int age;
    private int mark;
}
