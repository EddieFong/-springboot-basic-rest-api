package com.tw.apistackbase.dto;

import java.util.ArrayList;
import java.util.List;

public class Company {

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Company.count = count;
    }

    private static int count = 0;
    private final int id;

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private int employeeNumber;
    private String companyName;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private List<Employee> employees;

    public Company(String companyName, int employeeNumber, List<Employee> employees) {
        this.id = count;
        this.companyName = companyName;
        this.employeeNumber = employeeNumber;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }
}
