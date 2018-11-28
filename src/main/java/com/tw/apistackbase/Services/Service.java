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

    public static List<Company> getCompany() {
        return companies;
    }

    public static void setCompanies(List<Company> companies) {
        Service.companies = companies;
    }

    static List<Company> companies = new ArrayList<>();

    public void addEmployee(Employee employee) {
        Employee.setCount(Employee.getCount()+1);
        employees.add(employee);
    }

    public void addCompany(Company company) {
        Company.setCount(Company.getCount()+1);
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

    public  List<Employee>  getEmployeesById(int id) {
        for (Company company : companies) {
            if (company.getId()==id) {
                return company.getEmployees();
            }
        }
        return null;
    }

    public List<Company> getCompaniesPageQuery(int page, int pageSize) {
        List<Company> targetCompanies = new ArrayList<>();
        for (Company company : companies) {
            if ((company.getId()>=(page-1)*pageSize) && (company.getId()<page*pageSize ) ) {
                targetCompanies.add(company);
            }
        }
        return targetCompanies;
    }

    public List<Employee> getEmployeesPageQuery(int page, int pageSize) {
        List<Employee> targetEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if ((employee.getId()>=(page-1)*pageSize) && (employee.getId()<page*pageSize ) ) {
                targetEmployees.add(employee);
            }
        }
        return targetEmployees;
    }

    public  List<Employee> getEmployeesByGender(String gender) {

        List<Employee> targetEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getGender().contentEquals(gender)) {
                targetEmployees.add(employee);
            }
        }
        return targetEmployees;
    }

    public String delEmployee(int id) {
        String target = null;
        Employee targetEmployee = null;
        for (Employee employee : employees) {
            if (employee.getId()==id) {
                target = employee.getName()+ " is deleted";
                targetEmployee = employee;
            }
        }
        employees.remove(targetEmployee);
        return target;
    }

    public String delCompany(int id) {
        String target = null;
        Company targetCompany = null;
        for (Company company : companies) {
            if (company.getId()==id) {
                target = company.getCompanyName() + " is deleted";
                targetCompany = company;
            }
        }
        companies.remove(targetCompany);
        return target;
    }
}
