package com.baeldung.ls.service;

import com.baeldung.ls.persitence.model.Project;
import com.baeldung.ls.spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@SpringJUnitConfig(value = TestConfig.class)
@ActiveProfiles("default")
public class ProjectServiceIntegrationTest {

    @Autowired
    @Qualifier("projectServiceImpl")
    private IProjectService projectService;

    @Test
    public void whenSavingProject_thenOK() {
        Project project = new Project(2L,"name", LocalDate.now());
        Project savedProject = projectService.save(project);
        assertThat(savedProject, is(notNullValue()));
    }

}