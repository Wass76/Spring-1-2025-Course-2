package com.training.LearningManagmentSystem.teacher;

import com.training.LearningManagmentSystem.configuration.NotFoundInDatabaseException;
import com.training.LearningManagmentSystem.course.Course;
import com.training.LearningManagmentSystem.student.Student;
import com.training.LearningManagmentSystem.student.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public ResponseEntity<?> save(TeacherRequest request){
        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacherRepository.save(teacher);

        TeacherResponse response = mapToResponse(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



    public ResponseEntity<?> findById(Integer id) throws NotFoundInDatabaseException {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()-> new NotFoundInDatabaseException("student not found"));

        TeacherResponse response = mapToResponse(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    public TeacherResponse updateTeacher(Integer id, TeacherRequest request) throws NotFoundInDatabaseException {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Student not found"));
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());

        teacherRepository.save(teacher);
        return mapToResponse(teacher);
    }

    public ResponseEntity<?> deleteStudent(Integer id) throws NotFoundInDatabaseException {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()-> new NotFoundInDatabaseException("student not found"));
        if(teacher == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("teacher not found");
        }
        teacherRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("teacher deleted successfully");
    }



    private TeacherResponse mapToResponse(Teacher teacher) {
        TeacherResponse response = TeacherResponse.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .build();
        return response;
    }
}
