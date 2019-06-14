package com.baeldung.ls.persitence.repository;

import com.baeldung.ls.persitence.model.Project;
import java.util.Optional;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
