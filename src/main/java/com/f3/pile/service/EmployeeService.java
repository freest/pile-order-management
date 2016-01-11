package com.f3.pile.service;

import com.f3.pile.domain.Employee;
import com.f3.pile.repositories.EmployeeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    private Log log = LogFactory.getLog(EmployeeService.class);

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> listAllEmployees() { return employeeRepository.findAll(); }

    public Employee findById(Integer id) { return employeeRepository.findOne(id); }
}
