package com.f3.pile.service;

import com.f3.pile.domain.Project;
import com.f3.pile.repositories.ProjectRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    private Log log = LogFactory.getLog(ProjectService.class);

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public Iterable<Project> listAllProjects() { return projectRepository.findAll(); }

    public Project findById(Integer id) { return projectRepository.findOne(id); }

    public Project saveProject(Project project) {
        if(project.getId() != null) {
            project.setVersion(projectRepository.findOne(project.getId()).getVersion());
        }
        if(project.getForeman().getId() == null) {
            project.setForeman(null);
        }
        return projectRepository.save(project);
    }
}
