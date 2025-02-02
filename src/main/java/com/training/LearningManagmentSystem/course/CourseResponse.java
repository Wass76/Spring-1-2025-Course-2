package com.training.LearningManagmentSystem.course;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseResponse {
    private Long id;
    private String name;
    private String description;
}
