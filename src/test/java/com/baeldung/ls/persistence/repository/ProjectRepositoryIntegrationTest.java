package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

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
        Optional<Project> retrieveProject  =  projectRepository.findById(newProject.getId());

        // Then
        assertEquals(retrieveProject.get(), newProject);
    }


    @Test
    public void givenProject_whenFindByName_thenSuccess() {
        // Given
        Project project = new Project( randomAlphabetic(6), LocalDate.now());
        Project newProject = projectRepository.save(project);

        // When
        Optional<Project> retrieveProject  =  projectRepository.findByName(newProject.getName());

        // Then
        assertEquals(retrieveProject.get(), newProject);
    }

    @Test
    public void givenProjectCreated_whenFindByCreatedBetween_thenSuccess()
    {
        // Given
        Project oldProject =  new Project(randomAlphabetic(6), LocalDate.now().minusYears(1));
        projectRepository.save(oldProject);

        Project newProject =  new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Project newProject2 =  new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject2);

        // Then
        List<Project> retrieved  =  projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));

        // Assert
        assertThat(retrieved,hasItems(newProject, newProject2));
    }

}