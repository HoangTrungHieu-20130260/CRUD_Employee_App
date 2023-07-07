package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getByID(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmp(Employee employee) {
        return employeeRepository.save(employee);
    }
    public void deleteEmp(long id) {
        employeeRepository.deleteById(id);
    }
}
