package com.baeldung.ls.service.impl;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImplSetterInjection implements IProjectService {
    private IProjectRepository projectRepo;

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }

    @Autowired
    public void setProjectRepo(IProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }
}
