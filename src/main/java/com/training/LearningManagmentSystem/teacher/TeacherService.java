package com.training.LearningManagmentSystem.teacher;

import lombok.RequiredArgsConstructor;
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

        TeacherResponse response = TeacherResponse.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<?> findById(Integer id){
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if(teacher == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("teacher not found");
        }
        TeacherResponse response = TeacherResponse.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
