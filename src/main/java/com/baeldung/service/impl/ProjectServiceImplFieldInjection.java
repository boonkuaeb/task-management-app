package com.baeldung.service.impl;

import com.baeldung.persitence.model.Project;
import com.baeldung.persitence.repository.IProjectRepository;
import com.baeldung.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProjectServiceImplFieldInjection implements IProjectService {
    @Autowired
    private IProjectRepository projectRepo;

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }

}