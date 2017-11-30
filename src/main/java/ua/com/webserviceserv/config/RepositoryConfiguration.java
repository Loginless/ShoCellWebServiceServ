package ua.com.webserviceserv.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"ua.com.webserviceserv.repository"})
@EntityScan(basePackages = {"ua.com.webserviceserv.models"})
@EnableTransactionManagement

public class RepositoryConfiguration {
}
