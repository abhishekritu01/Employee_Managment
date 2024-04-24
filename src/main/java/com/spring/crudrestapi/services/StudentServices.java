package com.spring.crudrestapi.services;

import com.spring.crudrestapi.model.Student;
import com.spring.crudrestapi.repository.StudentRepository;

public interface StudentServices {

    Student saveStudent(Student student);

}
