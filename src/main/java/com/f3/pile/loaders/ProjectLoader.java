package com.f3.pile.loaders;

import com.f3.pile.domain.Project;
import com.f3.pile.repositories.EmployeeRepository;
import com.f3.pile.repositories.ProjectRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@DependsOn("employeeLoader")
public class ProjectLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProjectRepository projectRepository;
    private EmployeeRepository employeeRepository;

    private Log log = LogFactory.getLog(ProjectLoader.class);

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Project project = new Project();
        project.setName("ул. Вишняковская, 19/19");
        project.setForeman(employeeRepository.findOne(1));
        projectRepository.save(project);
        log.info("Project created: " + project.getId());

        project = new Project();
        project.setName("ул. Ревуцкого, 4");
        project.setForeman(employeeRepository.findOne(2));
        projectRepository.save(project);
        log.info("Project created: " + project.getId());

        project = new Project();
        project.setName("ул. П. Лумумбы, 23");
        project.setForeman(employeeRepository.findOne(3));
        projectRepository.save(project);
        log.info("Project created: " + project.getId());

        project = new Project();
        project.setName("ул. Маяковского, 7");
        projectRepository.save(project);
        log.info("Project created: " + project.getId());

        project = new Project();
        project.setName("бульвар Дружбы Народов, 55");
        projectRepository.save(project);
        log.info("Project created: " + project.getId());

        project = new Project();
        project.setName("пр. Победы, 9");
        projectRepository.save(project);
        log.info("Project created: " + project.getId());

        project = new Project();
        project.setName("ул. Ревуцкого, 4");
        projectRepository.save(project);
        log.info("Project created: " + project.getId());

        project = new Project();
        project.setName("ул. П. Лумумбы, 23");
        projectRepository.save(project);
        log.info("Project created: " + project.getId());

        project = new Project();
        project.setName("ул. Маяковского, 7");
        projectRepository.save(project);
        log.info("Project created: " + project.getId());

        project = new Project();
        project.setName("бульвар Дружбы Народов, 55");
        projectRepository.save(project);
        log.info("Project created: " + project.getId());

        project = new Project();
        project.setName("пр. Победы, 9");
        projectRepository.save(project);
        log.info("Project created: " + project.getId());
    }
}
