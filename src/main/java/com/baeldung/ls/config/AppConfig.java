package com.baeldung.ls.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.baeldung.ls"})
@EntityScan(basePackages = {"com.baeldung.ls.persistence.model"})
@EnableJpaRepositories(basePackages = { "com.baeldung.ls.persistence.repository" })
public class AppConfig {

}
