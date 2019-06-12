package com.baeldung.persitence.repository;

import com.baeldung.persitence.model.Project;
import java.util.Optional;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
