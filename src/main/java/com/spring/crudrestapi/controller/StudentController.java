package com.spring.crudrestapi.controller;


import com.spring.crudrestapi.model.Student;
import com.spring.crudrestapi.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private StudentServices studentServices;
    public StudentController(StudentServices studentServices) {
        super();
        this.studentServices = studentServices;
    }

    // create student rest api
    @PostMapping()
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentServices.saveStudent(student), HttpStatus.CREATED);
    }

}
