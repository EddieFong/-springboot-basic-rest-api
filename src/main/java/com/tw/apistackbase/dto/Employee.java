package com.tw.apistackbase.dto;

public class Employee {
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employee.count = count;
    }

    static int count=0;
    private final int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private  String name;
    private  int age;
    private  String gender;
    private  int salary;

    public Employee(String name, int age, String gender, int salary) {
        this.id = count;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;


    }
}
