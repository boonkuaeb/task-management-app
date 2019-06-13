package com.baeldung.service;

import com.baeldung.persitence.model.Project;

import java.util.Optional;

public interface IProjectService {
    Optional<Project> findById(Long id);
    Project save(Project project);
}
