package com.java8.controller;


import com.java8.model.Employee;
import com.java8.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Employee employee) {

        System.out.println(employee);
        return employeeService.add(employee);
    }

    @PostMapping("/addAll")
    public ResponseEntity<String> addAll(@RequestBody List<Employee> employees) {

        System.out.println(employees);
        return employeeService.addAll(employees);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Integer i) {
        System.out.println("Get By Id is called");
        return employeeService.getById(i);
    }

    @GetMapping("/findById")
    public ResponseEntity<Employee> findById(@RequestParam Integer i){
        return employeeService.findById(i);
    }

}
