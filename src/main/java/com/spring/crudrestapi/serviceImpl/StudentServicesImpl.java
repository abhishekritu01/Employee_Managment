package com.spring.crudrestapi.serviceImpl;

import com.spring.crudrestapi.model.Student;
import com.spring.crudrestapi.repository.StudentRepository;
import com.spring.crudrestapi.services.StudentServices;
import org.springframework.stereotype.Service;

@Service
public class StudentServicesImpl implements StudentServices {

    private StudentRepository studentRepository;

    public StudentServicesImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
