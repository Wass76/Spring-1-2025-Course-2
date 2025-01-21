package com.training.LearningManagmentSystem.student;

import com.training.LearningManagmentSystem.course.Course;
import com.training.LearningManagmentSystem.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentResponse createStudent(StudentRequest request) {
        Course course = courseRepository.findById(request.getCourse()).orElse(null);
        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .age(request.getAge())
                .mark(request.getMark())
                .course(course)
                .build();
        studentRepository.save(student);

        return StudentResponse.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .studentId(student.getId())
                .mark(student.getMark())
                .age(student.getAge())
                .build();
    }
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id , Student request){

        Student updatedStud = studentRepository.findById(id).orElse(null);

        updatedStud.setFirstName(request.getFirstName());
        updatedStud.setLastName(request.getLastName());
        updatedStud.setAge(request.getAge());
        updatedStud.setMark(request.getMark());

        return studentRepository.save(updatedStud);
//        return updatedStud;
    }

    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }
}
