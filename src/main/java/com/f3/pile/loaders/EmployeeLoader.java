package com.f3.pile.loaders;

import com.f3.pile.domain.Employee;
import com.f3.pile.repositories.EmployeeRepository;
import com.f3.pile.service.EmployeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class EmployeeLoader implements ApplicationListener<ContextRefreshedEvent> {
    private EmployeeRepository employeeRepository;

    private Log log = LogFactory.getLog(EmployeeService.class);

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Employee employee = new Employee();
        employee.setLastName("Лукьянчук");
        employee.setFirstName("Игорь");
        employeeRepository.save(employee);
        log.info("Employee created: " + employee.getId());

        employee = new Employee();
        employee.setLastName("Соколов");
        employee.setFirstName("Дима");
        employeeRepository.save(employee);
        log.info("Employee created: " + employee.getId());

        employee = new Employee();
        employee.setLastName("Касич");
        employee.setFirstName("Коля");
        employeeRepository.save(employee);
        log.info("Employee created: " + employee.getId());
    }
}
