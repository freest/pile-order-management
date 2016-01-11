package com.f3.pile.web;

import com.f3.pile.domain.Project;
import com.f3.pile.repositories.EmployeeRepository;
import com.f3.pile.repositories.ProjectRepository;
import com.f3.pile.service.EmployeeService;
import com.f3.pile.service.NlsService;
import com.f3.pile.service.OrderService;
import com.f3.pile.service.ProjectService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private NlsService nlsService;

    private Log log = LogFactory.getLog(ProjectController.class);

    @RequestMapping("/projects")
    public ModelAndView buildings() {
        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("nlsService", nlsService);
        modelAndView.addObject("foremans", employeeService.listAllEmployees());
        modelAndView.addObject("projects", projectService.listAllProjects());
        return modelAndView;
    }

    @RequestMapping(value = "/project", params = "id")
    public ModelAndView building(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("project");
        Project project = projectService.findById(id);
        modelAndView.addObject("nlsService", nlsService);
        modelAndView.addObject("project", project);
        modelAndView.addObject("foremans", employeeService.listAllEmployees());
        modelAndView.addObject("orders", orderService.listByProject(project));
        return modelAndView;
    }

    @RequestMapping("/createProject")
    @ResponseBody
    public String createProject(@RequestParam Map<String, String> data) {
        Project project = new Project();
        project.setName(data.get("name"));
        project.setForeman(employeeService.findById(Integer.valueOf(data.get("foremanId"))));
        projectService.saveProject(project);
        return project.getId().toString();
    }

    @RequestMapping("/updateProject")
    @ResponseBody
    public String updateProject(@RequestParam Map<String, String> data) {
        Project project = projectService.findById(Integer.valueOf(data.get("projectId")));
        project.setName(data.get("name"));
        project.setForeman(employeeService.findById(Integer.valueOf(data.get("foremanId"))));
        projectService.saveProject(project);
        return project.getId().toString();
    }
}
