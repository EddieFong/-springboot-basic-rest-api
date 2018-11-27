package com.tw.apistackbase.Services;

import com.tw.apistackbase.dto.Company;
import com.tw.apistackbase.dto.Employee;

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

    public static List<Company> getCompanies() {
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
}
