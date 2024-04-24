package com.spring.crudrestapi.serviceImpl;

import com.spring.crudrestapi.model.Employee;
import com.spring.crudrestapi.repository.EmployeeRepository;
import com.spring.crudrestapi.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

//        if (employee.isPresent()) {
//            return employee.get();
//        } else {
//            //throw new RuntimeException(" Employee not found for id :: " + id);
//            throw new RuntimeException(" Employee not found for id :: " + id);
//        }

        // lambda expression
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(" Employee not found for id :: " + id));

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // check if the employee exists
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException(" Employee not found for id :: " + id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        //save existing employee to database
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //check if the employee exists
        employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException(" Employee not found for id :: " + id));

        employeeRepository.deleteById(id);

    }


}
