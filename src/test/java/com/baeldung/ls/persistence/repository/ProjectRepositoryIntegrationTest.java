package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
        Project project = new Project(randomAlphabetic(6), LocalDate.now());
        Project newProject = projectRepository.save(project);

        // When
        Optional<Project> retrieveProject = projectRepository.findById(newProject.getId());

        // Then
        assertEquals(retrieveProject.get(), newProject);
    }


    @Test
    public void givenProject_whenFindByName_thenSuccess() {
        // Given
        Project project = new Project(randomAlphabetic(6), LocalDate.now());
        Project newProject = projectRepository.save(project);

        // When
        Optional<Project> retrieveProject = projectRepository.findByName(newProject.getName());

        // Then
        assertEquals(retrieveProject.get(), newProject);
    }

    @Test
    public void givenProjectCreated_whenFindByCreatedBetween_thenSuccess() {
        // Given
        Project oldProject = new Project(randomAlphabetic(6), LocalDate.now().minusYears(1));
        projectRepository.save(oldProject);

        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Project newProject2 = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject2);

        // Then
        List<Project> retrieved = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));

        // Assert
        assertThat(retrieved, hasItems(newProject, newProject2));
    }

    @Test
    public void givenPorjectCreated_whenFindAllPaginated_thenSuccess() {
        // When
        Page<Project> retrievedProject = projectRepository.findAll(PageRequest.of(0, 2));

        // Then
        assertThat(retrievedProject.getContent(), hasSize(2));
    }

    @Test
    public void givenProjectCreated_whenFindAlSort_thenSuccess() {
        // When
        List<Project> retrievedProject = (List<Project>) projectRepository.findAll(Sort.by(Sort.Order.asc("name")));
        List<Project> sortProjects = retrievedProject.stream().collect(Collectors.toList());

        // Do sort by name again to make sure that projects list still same from query
        sortProjects.sort(Comparator.comparing(Project::getName));

        // Then
        assertEquals(sortProjects, retrievedProject);
    }

    @Test
    public void givenProjectCreated_whenFindAlPaginatedSort_thenSuccess() {
        // When
        Page<Project> retrievedProject = projectRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Order.asc("name"))));
        assertThat(retrievedProject.getContent(), hasSize(2));

    }


    @Test
    public void givenNewProject_thenSavedSuccess() {
        Project newProject = new Project("First Project", LocalDate.now());
        assertNotNull(projectRepository.save(newProject));
    }
}