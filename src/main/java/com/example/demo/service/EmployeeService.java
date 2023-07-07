package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public List<Employee> getAll();
    public Employee getByID(long id);
    public Employee updateEmp(Employee employee);
    public void deleteEmp(long id);


}
