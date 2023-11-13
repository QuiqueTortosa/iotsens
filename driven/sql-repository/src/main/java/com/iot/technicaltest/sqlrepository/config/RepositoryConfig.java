package com.iot.technicaltest.sqlrepository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.iot.technicaltest.sqlrepository"})
public class RepositoryConfig {

}
