package com.baeldung.ls.service.impl;

import com.baeldung.ls.persitence.model.Project;
import com.baeldung.ls.persitence.repository.IProjectRepository;
import com.baeldung.ls.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImplFieldInjection implements IProjectService {
    @Autowired
    @Qualifier("projectRepositoryImpl2")
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
