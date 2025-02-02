package com.training.LearningManagmentSystem.student;

import com.training.LearningManagmentSystem.course.Course;
import com.training.LearningManagmentSystem.teacher.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDENTS")
public class Student {
    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    private String lastName;
    private Integer age;
    private Integer mark;

    @ManyToOne
    private Course course;

    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers;
}
