package com.training.LearningManagmentSystem.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
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
