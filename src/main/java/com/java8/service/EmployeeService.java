package com.java8.service;

import com.java8.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public ResponseEntity<String> add(Employee employee);

    public ResponseEntity<String> addAll(List<Employee> employees);

    public ResponseEntity<Employee> getById(int i);

    public ResponseEntity<Employee> findById(int i);
}
