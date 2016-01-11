package com.f3.pile.web;

import com.f3.pile.domain.Order;
import com.f3.pile.domain.Project;
import com.f3.pile.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private NlsService nlsService;

    @RequestMapping(value = "/project",params = "id")
    public ModelAndView building(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("project");
        Project project = projectService.findById(id);
        modelAndView.addObject("nlsService", nlsService);
        modelAndView.addObject("project", project);
        modelAndView.addObject("foremans", employeeService.listAllEmployees());
        modelAndView.addObject("orders", orderService.listByProject(project));
        return modelAndView;
    }

    @RequestMapping("/projects")
    public ModelAndView buildings() {
        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("nlsService", nlsService);
        modelAndView.addObject("foremans", employeeService.listAllEmployees());
        modelAndView.addObject("projects", projectService.listAllProjects());
        return modelAndView;
    }

    @RequestMapping("/employees")
    public ModelAndView employees() {
        ModelAndView modelAndView = new ModelAndView("employees");
        modelAndView.addObject("employees", employeeService.listAllEmployees());
        return modelAndView;
    }
}
