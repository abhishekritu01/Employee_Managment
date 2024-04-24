package com.spring.crudrestapi.repository;

import com.spring.crudrestapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}


