package com.baeldung.ls.controller.rest;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/projects")
public class ProjectRestController {

    private IProjectService projectService;

    public ProjectRestController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = "/{id}")
    public Project findOne(@PathVariable Long id) {
        return projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/1")
    public Project findOne() {
        return new Project("testName", LocalDate.now());
    }

    @PostMapping
    public void create(@RequestBody Project newProject) {
        this.projectService.save(newProject);
    }


}
