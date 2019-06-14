package com.baeldung.ls.service.impl;

import com.baeldung.ls.persitence.model.Project;
import com.baeldung.ls.persitence.repository.IProjectRepository;
import com.baeldung.ls.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl  implements IProjectService {

    private final static Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private IProjectRepository projectRepo;

    public ProjectServiceImpl(@Qualifier("projectRepositoryImpl") IProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Project Service >> Finding project by ID {}",id);
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        LOG.debug("Project Service >> Save Project {}",project);
        return projectRepo.save(project);
    }
}
