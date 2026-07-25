package com.medhat.ums.services;

import com.medhat.ums.dto.StudentDTO;
import com.medhat.ums.entities.Student;
import com.medhat.ums.projections.StudentProjection;
import com.medhat.ums.repositories.StudentRepository;
import com.medhat.ums.repositories.specs.StudentSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentProjection> getSummaries() {
        return studentRepository.findAllProjectedBy();
    }

    public List<StudentDTO> getDTOs() {
        return studentRepository.findAllStudentDTOs();
    }

    public Student addStudent(Student student) {
        if (studentRepository.existsByUniversityId(student.getUniversityId())) {
            throw new RuntimeException("Already exists!!! >:c");
        }
        return studentRepository.save(student);
    }

    public List<Student> searchStudents(String keyword) {
        return studentRepository.findAll(StudentSpecifications.nameContains(keyword));
    }
}
