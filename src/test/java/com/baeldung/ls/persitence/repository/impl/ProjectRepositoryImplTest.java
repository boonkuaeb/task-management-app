package com.baeldung.ls.persitence.repository.impl;

import com.baeldung.ls.persitence.model.Project;
import com.baeldung.ls.persitence.repository.IProjectRepository;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProjectRepositoryImplTest {

    @Autowired
    @Qualifier("projectRepositoryImpl")
    private IProjectRepository projectRepository;


    @Test
    public void whenSavingNewProject_thenSuccess() {
        // Given
        Project project = new Project(generateLong(), randomAlphabetic(6), LocalDate.now());
        // Then
        assertNotNull(projectRepository.save(project));

    }


    @Test
    public void givenProject_whenFindById_thenSuccess() {
        // Given
        Project project = new Project(generateLong(), randomAlphabetic(6), LocalDate.now());
        Project newProject = projectRepository.save(project);

        // When
        Optional<Project> retreivedProject  =  projectRepository.findById(newProject.getId());

        // Then
        assertEquals(retreivedProject.get(), newProject);
    }

    private long generateLong() {
        long leftLimit = 10L;
        long rightLimit = 100L;
        long generatedLong = new RandomDataGenerator().nextLong(leftLimit, rightLimit);
        return generatedLong;
    }
}