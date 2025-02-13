package com.training.LearningManagmentSystem.teacher;

import com.training.LearningManagmentSystem.validation.ObjectValidator;
import com.training.LearningManagmentSystem.exception.NotFoundInDatabaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ObjectValidator<TeacherRequest> validator;


    public ResponseEntity<?> save(TeacherRequest request) {
        validator.validate(request);
        Teacher teacher = Teacher.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
        teacherRepository.save(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToResponse(teacher));
    }


    public ResponseEntity<?> findById(Integer id) throws NotFoundInDatabaseException {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new NotFoundInDatabaseException("teacher not found"));
        return ResponseEntity.status(HttpStatus.OK).body(mapToResponse(teacher));
    }


    public ResponseEntity updateTeacher(Integer id, TeacherRequest request) throws NotFoundInDatabaseException {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("teacher not found"));
        validator.validate(request);
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());

        teacherRepository.save(teacher);
        return ResponseEntity.ok().body(mapToResponse(teacher));
    }

    public ResponseEntity<?> deleteTeacher(Integer id) throws NotFoundInDatabaseException {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new NotFoundInDatabaseException("teacher not found"));
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
