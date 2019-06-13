package com.baeldung.service.impl;

import com.baeldung.persitence.model.Project;
import com.baeldung.persitence.repository.IProjectRepository;
import com.baeldung.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    public void setProjectRepo(@Qualifier("projectRepositoryImpl2") IProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }
}
