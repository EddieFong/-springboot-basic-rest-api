package com.tw.apistackbase.Services;

import com.tw.apistackbase.dto.Company;
import com.tw.apistackbase.dto.Employee;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
public class Service {
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    List<Employee> employees = new ArrayList<>();

    public List<Company> getCompany() {
        return companies;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    List<Company> companies = new ArrayList<>();

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

    public Company updateCompany(int id, Company company) {
        Company targetCompany = null;
        for (Company companyElement : companies) {
            if (companyElement.getId()==id) {
                targetCompany = companyElement;
            }
        }
        targetCompany.setCompanyName(company.getCompanyName());
        targetCompany.setEmployeeNumber(company.getEmployeeNumber());
        targetCompany.setEmployees(company.getEmployees());
        return targetCompany;
    }
}
