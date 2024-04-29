package com.spring.crudrestapi.serviceImpl;

import com.spring.crudrestapi.model.Student;
import com.spring.crudrestapi.repository.StudentRepository;
import com.spring.crudrestapi.services.StudentServices;
import jakarta.persistence.Column;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Student> getAllStudents() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("No student found");
        }
    }

    @Override
    public Student getStudentById(long id) {
        try {
            return studentRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException(" Student not found for id :: " + id);
        }
    }
// "studentId": 2,
//         "studentName": "Arnav kumar jha ",
//         "studentAddress": "123 Main St, City",
//         "studentEmail": "abhishekritu810219.com",
//         "studentPhone": "9473337583",
//         "studentCourse": "Computer Science Engineering",
//         "studentDepartment": "Computer Science Engineering",
//         "studentBatch": "2024"

    @Override
    public Student updateStudent(Student student, long id) {
        try {
            Student existingStudent = studentRepository.findById(id).get();
            existingStudent.setStudentName(student.getStudentName());
            existingStudent.setStudentAddress(student.getStudentAddress());
            existingStudent.setStudentEmail(student.getStudentEmail());
            existingStudent.setStudentPhone(student.getStudentPhone());
            existingStudent.setStudentCourse(student.getStudentCourse());
            existingStudent.setStudentDepartment(student.getStudentDepartment());
            existingStudent.setStudentBatch(student.getStudentBatch());
            return studentRepository.save(existingStudent);
        } catch (Exception e) {
            throw new RuntimeException(" Student not found for id :: " + id);
        }
    }

    @Override
    public void deleteStudent(long id) {
        try {
            studentRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(" Student not found for id :: " + id);
        }
    }


}
