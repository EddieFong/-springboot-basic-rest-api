package com.tw.apistackbase.controller;

import com.tw.apistackbase.Services.Service;
import com.tw.apistackbase.dto.Company;
import com.tw.apistackbase.dto.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/companies")
public class CompaniesResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    Service service = new Service();

    @GetMapping(path = "", produces = {"application/json"})
    public ResponseEntity<List<Company>> getAll(@RequestParam(value = "page", required=false) Integer page, @RequestParam(value = "pageSize", required=false) Integer pageSize) {
        if (pageSize == null) return ResponseEntity.ok(service.getCompany());
        return ResponseEntity.ok(service.getCompaniesPageQuery(page,pageSize));
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<String> add(@RequestBody Company company) {
        List<Employee> tempEmployees = new ArrayList<>();
        for (Employee employee : company.getEmployees()) {
            Employee newEmployee = new Employee(employee.getName(), employee.getAge(), employee.getGender(), employee.getSalary());
            service.addEmployee(newEmployee);
            tempEmployees.add(newEmployee);
        }

        Company newCompany = new Company(company.getCompanyName(), company.getEmployeeNumber(), tempEmployees);
        service.addCompany(newCompany);
        return ResponseEntity.ok("Success: id = " + newCompany.getId());
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<Company> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCompany(id));
    }

    @GetMapping(path = "/{id}/employees", produces = {"application/json"})
    public ResponseEntity<List<Employee>> getEmployeesById(@PathVariable int id) {
        return ResponseEntity.ok(service.getEmployeesById(id));
    }

    @DeleteMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<String> delCompanyById(@PathVariable int id) {
        return ResponseEntity.ok(service.delCompany(id));
    }


}
