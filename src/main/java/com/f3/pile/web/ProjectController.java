package com.f3.pile.web;

import com.f3.pile.domain.Project;
import com.f3.pile.repositories.EmployeeRepository;
import com.f3.pile.repositories.ProjectRepository;
import com.f3.pile.service.EmployeeService;
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

    private Log log = LogFactory.getLog(ProjectController.class);

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
