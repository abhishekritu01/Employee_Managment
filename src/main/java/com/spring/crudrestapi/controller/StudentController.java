package com.spring.crudrestapi.controller;

import com.spring.crudrestapi.model.Student;
import com.spring.crudrestapi.services.StudentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentServices.getAllStudents();
    }


    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId) {
        try {
            return new ResponseEntity<Student>(studentServices.getStudentById(studentId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return new ResponseEntity<>(studentServices.updateStudent(student, id), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id) {
        studentServices.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
