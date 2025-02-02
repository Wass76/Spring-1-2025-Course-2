package com.training.LearningManagmentSystem.teacher;

import com.training.LearningManagmentSystem.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_id",
            sequenceName = "teacher_id"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_id")
    private Integer id;


    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "student_teacher",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Student> students;

}
