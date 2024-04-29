package com.spring.crudrestapi.services;

import com.spring.crudrestapi.model.Student;
import com.spring.crudrestapi.repository.StudentRepository;

import java.util.List;

public interface StudentServices {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(long id);

    Student updateStudent(Student student, long id);

    void deleteStudent(long id);


}
