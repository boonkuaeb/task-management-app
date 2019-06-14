package com.baeldung.ls.spring;

import com.baeldung.LsApp;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
