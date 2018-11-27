package com.tw.apistackbase.controller;

import com.tw.apistackbase.Services.Service;
import com.tw.apistackbase.dto.Company;
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
        return ResponseEntity.ok(service.getCompanies());
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<String> add(@RequestBody Company company) {
        Company newCompany = new Company(company.getCompanyName(), company.getEmployeeNumber());
        service.addCompany(newCompany);
        return ResponseEntity.ok("Success: id = " + newCompany.getId());
    }
}
