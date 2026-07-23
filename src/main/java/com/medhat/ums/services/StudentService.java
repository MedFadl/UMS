package com.medhat.ums.services;


import com.medhat.ums.entities.Student;
import com.medhat.ums.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;



    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
