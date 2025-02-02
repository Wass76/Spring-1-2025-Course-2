package com.training.LearningManagmentSystem.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<?> saveTeacher(@RequestBody TeacherRequest teacherRequest) {
        return teacherService.save(teacherRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Integer id) {
        return teacherService.findById(id);
    }






}
