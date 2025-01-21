package com.training.LearningManagmentSystem.student;

import com.training.LearningManagmentSystem.course.Course;
import com.training.LearningManagmentSystem.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {

        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.createStudent(request));
    }

    @GetMapping("{id}")
    public Map<String, Object> getById( @PathVariable Long id) {
        Student student = studentService.getStudent(id);
        Map<String , Object> map = new HashMap<>();
        map.put("id" , student.getId());
        map.put("firstName" , student.getFirstName());
//        map.put("lastName" , student.getLastName());
//        map.put("age" , student.getAge());
//        map.put("mark" , student.getMark());
        return map;
    }

    @PutMapping("{id}")
    //PUT:  api/v1/students/1
    // Body:
        // {
        //    "firstName" : "Spring 1",
        //    "lastName" : "boot 1",
        //    "age" : 22,
        //    "mark" : 100
        //}
    public Student updateStudent(@PathVariable Long id , @RequestBody Student request){
        return studentService.updateStudent(id, request);
    }

    @DeleteMapping("{id}")
    public Map<String , Object> deleteStudent(@PathVariable Long id) {
        Map<String , Object > map = new HashMap<>();
        map.put("message" , studentService.deleteStudent(id));
        return map;
    }

}
