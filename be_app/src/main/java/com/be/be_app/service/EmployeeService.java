package com.be.be_app.service;

import com.be.be_app.model.Employee;
import com.be.be_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired

    public EmployeeRepository employeeRepository;
    @RequestMapping("/employees")
    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void updateEmployee(Long id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Employee was not found")
        );
        employee.setId(id);
        employee1 = employee;
        employeeRepository.save(employee1);
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
