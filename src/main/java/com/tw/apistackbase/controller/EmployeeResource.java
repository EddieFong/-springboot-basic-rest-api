package com.tw.apistackbase.controller;

import com.tw.apistackbase.Services.Service;
import com.tw.apistackbase.dto.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    Service service = new Service();

    @GetMapping(path = "", produces = {"application/json"})
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getEmployees());
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<String> add(@RequestBody Employee employee) {
        service.addEmployee(new Employee(employee.getName(),employee.getAge(),employee.getGender(),employee.getSalary()));
        return ResponseEntity.ok("Success");
    }
}
