package com.baeldung.ls.persistence.repository.impl;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProjectRepositoryImplTest {

    @Autowired
    private IProjectRepository projectRepository;


    @Test
    public void whenSavingNewProject_thenSuccess() {
        // Given
        Project project = new Project(randomAlphabetic(6), LocalDate.now());
        // Then
        assertNotNull(projectRepository.save(project));

    }


    @Test
    public void givenProject_whenFindById_thenSuccess() {
        // Given
        Project project = new Project( randomAlphabetic(6), LocalDate.now());
        Project newProject = projectRepository.save(project);

        // When
        Optional<Project> retreivedProject  =  projectRepository.findById(newProject.getId());

        // Then
        assertEquals(retreivedProject.get(), newProject);
    }

}