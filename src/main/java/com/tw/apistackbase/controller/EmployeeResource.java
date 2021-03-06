package com.tw.apistackbase.controller;

import com.tw.apistackbase.Services.Service;
import com.tw.apistackbase.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    Service service;

    @Autowired
    public EmployeeResource(Service service) {
        this.service = service;
    }

    @GetMapping(path = "", produces = {"application/json"})
    public ResponseEntity<List<Employee>> getAll(@RequestParam(required = false) String gender) {
        if (gender == null) return ResponseEntity.ok(service.getEmployees());
        return ResponseEntity.ok(service.getEmployeesByGender(gender));
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<String> add(@RequestBody Employee employee) {
        Employee newEmployee = new Employee(employee.getName(), employee.getAge(), employee.getGender(), employee.getSalary());
        service.addEmployee(newEmployee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("employees1/" + new Integer(newEmployee.getId()).toString()));
        headers.add("Location",  "employees2/" + new Integer(newEmployee.getId()).toString());
        return new ResponseEntity<String>("Success", headers, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getEmployee(id));
    }

    @DeleteMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<String> delEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(service.delEmployee(id));
    }

}
