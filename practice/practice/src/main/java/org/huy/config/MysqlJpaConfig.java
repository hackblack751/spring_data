package org.huy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.huy.repository.mysql"
        , entityManagerFactoryRef = "mysqlEntityManagerFactory"
        , transactionManagerRef = "mysqlTransactionManager")
public class MysqlJpaConfig {
}
