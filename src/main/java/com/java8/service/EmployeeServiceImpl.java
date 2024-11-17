package com.java8.service;

import com.java8.model.Employee;
import com.java8.repo.EmployeeRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<String> add(Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        if(employee1!=null)
        {
            return new ResponseEntity<>("Employee saved successfully", HttpStatus.CREATED);
        }
        else
            return  ResponseEntity.ok("Employee is not saved");
    }

    @Override
    public ResponseEntity<String> addAll(List<Employee> employees) {
        List<Employee> savedEmployees = employeeRepository.saveAll(employees);
        return ResponseEntity.ok("All Employees is saved");
    }

    @Override
    public ResponseEntity<Employee> getById(int i) {
        Optional<Employee> employee = employeeRepository.findById(i);
        Optional<Employee> resultantEmployee =  Optional.ofNullable(employee).orElseThrow(()->new IllegalArgumentException("Employee with the given id is not found"));

        return ResponseEntity.ok(resultantEmployee.get());
    }

    @Override
    public ResponseEntity<Employee> findById(int i) {
        Employee employee1 =  employeeRepository.findById(i).get();
        return ResponseEntity.ok(employee1);

    }
}
