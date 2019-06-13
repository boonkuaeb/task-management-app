package com.baeldung.service.impl;

import com.baeldung.persitence.model.Project;
import com.baeldung.persitence.repository.IProjectRepository;
import com.baeldung.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProjectServiceImpl  implements IProjectService {

    private IProjectRepository projectRepo;

    public ProjectServiceImpl(@Qualifier("projectRepositoryImpl2") IProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }
}
