package com.tw.apistackbase.controller;

import com.tw.apistackbase.Services.Service;
import com.tw.apistackbase.dto.Company;
import com.tw.apistackbase.dto.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/companies")
public class CompaniesResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    Service service = new Service();


    @GetMapping(path = "", produces = {"application/json"})
    public ResponseEntity<List<Company>> getAll() {
        return ResponseEntity.ok(service.getCompany());
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<String> add(@RequestBody Company company) {
        for (Employee employee : company.getEmployees()) {
            Employee newEmployee = new Employee(employee.getName(), employee.getAge(), employee.getGender(), employee.getSalary());
            service.addEmployee(newEmployee);
        }

        Company newCompany = new Company(company.getCompanyName(), company.getEmployeeNumber(), company.getEmployees());
        service.addCompany(newCompany);
        return ResponseEntity.ok("Success: id = " + newCompany.getId());
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<Company> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCompany(id));
    }
}
