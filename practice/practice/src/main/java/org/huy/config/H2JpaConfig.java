package org.huy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "org.huy.repository.h2"
        , entityManagerFactoryRef = "h2EntityManagerFactory"
        , transactionManagerRef = "h2TransactionManager"
)
public class H2JpaConfig {
}
