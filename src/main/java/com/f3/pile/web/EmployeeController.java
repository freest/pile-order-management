package com.f3.pile.web;

import com.f3.pile.domain.Employee;
import com.f3.pile.service.EmployeeService;
import com.f3.pile.service.NlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private NlsService nlsService;

    @RequestMapping("/employees")
    public ModelAndView employees() {
        ModelAndView modelAndView = new ModelAndView("employees");
        modelAndView.addObject("nlsService", nlsService);
        modelAndView.addObject("employees", employeeService.listAllEmployees());
        return modelAndView;
    }

    @RequestMapping("/saveEmployee")
    @ResponseBody
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
}
