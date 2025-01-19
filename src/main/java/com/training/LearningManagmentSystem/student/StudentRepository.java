package com.training.LearningManagmentSystem.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student , Long> {
}
