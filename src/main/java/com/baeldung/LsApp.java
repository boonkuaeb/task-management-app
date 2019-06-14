package com.baeldung;

import com.baeldung.persitence.model.Project;
import com.baeldung.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class LsApp {

    @Autowired
    @Qualifier("projectServiceImpl")
    IProjectService projectService;

    public static void main(String[] args) {
        SpringApplication.run(LsApp.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        Project project = new Project(1L, "My First Project", LocalDate.now());
        projectService.save(project);

        Optional<Project> optionalProject = projectService.findById(1L);
        optionalProject.ifPresent(System.out::println);

    }
}