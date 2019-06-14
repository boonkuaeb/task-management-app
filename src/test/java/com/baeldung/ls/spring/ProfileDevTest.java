package com.baeldung.ls.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ProfileDevTest {
    @Autowired
    private Environment env;

    @Test
    public void readProps() {
        String value = env.getProperty("project.suffix") ;
        assertEquals("124", value);
    }
}
