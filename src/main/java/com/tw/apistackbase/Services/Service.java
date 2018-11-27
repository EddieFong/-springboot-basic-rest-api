package com.tw.apistackbase.Services;

import com.tw.apistackbase.dto.Company;
import com.tw.apistackbase.dto.Employee;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(List<Employee> employees) {
        Service.employees = employees;
    }

    static List<Employee> employees = new ArrayList<>();

    public static List<Company> getCompany() {
        return companies;
    }

    public static void setCompanies(List<Company> companies) {
        Service.companies = companies;
    }

    static List<Company> companies = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public Company getCompany(int id) {
         for (Company company : companies) {
            if (company.getId()==id) {
                return company;
            }
        }
        return null;
    }

    public Employee getEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId()==id) {
                return employee;
            }
        }
        return null;
    }
}
