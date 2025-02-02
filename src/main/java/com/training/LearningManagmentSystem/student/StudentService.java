package com.training.LearningManagmentSystem.student;

import com.training.LearningManagmentSystem.course.Course;
import com.training.LearningManagmentSystem.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public StudentResponse getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }



    public StudentResponse createStudent(StudentRequest request) {
        Course course = courseRepository.findById(request.getCourse())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .age(request.getAge())
                .mark(request.getMark())
                .course(course)
                .build();

        student = studentRepository.save(student);
        return mapToResponse(student);
    }

    @Transactional
    public StudentResponse updateStudent(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(request.getCourse())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAge(request.getAge());
        student.setMark(request.getMark());
        student.setCourse(course);

        student = studentRepository.save(student);
        return mapToResponse(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    private StudentResponse mapToResponse(Student student) {
        return StudentResponse.builder()
                .studentId(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .mark(student.getMark())
                .course(student.getCourse().getId())
                .build();
    }
}
