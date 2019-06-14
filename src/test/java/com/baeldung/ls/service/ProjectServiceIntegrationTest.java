package com.baeldung.ls.service;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@SpringJUnitConfig(value = TestConfig.class)
public class ProjectServiceIntegrationTest {

    @Autowired
    @Qualifier(value = "projectServiceImpl")
    private IProjectService projectService;

    @Test
    public void whenSavingProject_thenOK() {
        Project savedProject = projectService.save(new Project("name", LocalDate.now()));
        assertThat(savedProject, is(notNullValue()));
    }

}