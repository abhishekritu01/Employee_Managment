package com.spring.crudrestapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "students_information")
public class Student {

    @Id
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_address")
    private String studentAddress;

    @Column(name = "student_email")
    private String studentEmail;

    @Column(name = "student_phone")
    private String studentPhone;

    @Column(name = "student_course")
    private String studentCourse;

    @Column(name = "student_department")
    private String studentDepartment;

    @Column(name = "student_batch")
    private String studentBatch;
}
