package com.spring.crudrestapi.repository;

import com.spring.crudrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

