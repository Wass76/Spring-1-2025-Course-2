package com.training.LearningManagmentSystem.student;

import com.training.LearningManagmentSystem.course.Course;
import com.training.LearningManagmentSystem.course.CourseRepository;
import com.training.LearningManagmentSystem.teacher.Teacher;
import com.training.LearningManagmentSystem.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private final TeacherRepository teacherRepository;

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

        List<Teacher> teachers = new ArrayList<>();
        for(Integer id : request.getTeacherId()){
            Teacher teacher = teacherRepository.findById(id).orElse(null);
            if(teacher != null){
                teachers.add(teacher);
            }
        }
        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .age(request.getAge())
                .mark(request.getMark())
                .course(course)
                .teachers(teachers)
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
        List<Integer> teacherIds = new ArrayList<>();
        for(Teacher t : student.getTeachers()){
            teacherIds.add(t.getId());
        }
        return StudentResponse.builder()
                .studentId(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .mark(student.getMark())
                .course(student.getCourse().getId())
                .teachers(teacherIds)
                .build();
    }
}
