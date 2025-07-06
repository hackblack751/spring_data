package org.huy.config;

import com.zaxxer.hikari.HikariDataSource;
import org.huy.property.H2Properties;
import org.huy.property.MysqlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "mysqlDataSource")
    @Primary
    public DataSource mysqlDataSource(MysqlProperties mysqlProperties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(mysqlProperties.getUrl());
        dataSource.setUsername(mysqlProperties.getUser());
        dataSource.setPassword(mysqlProperties.getPassword());
        dataSource.setMaximumPoolSize(mysqlProperties.getMaxPoolSize());
        dataSource.setMinimumIdle(mysqlProperties.getMinimumIdle());

        return dataSource;
    }

    @Bean(name = "h2DataSource")
    public DataSource h2DataSource(H2Properties h2Properties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(h2Properties.getUrl());
        dataSource.setUsername(h2Properties.getUser());
        dataSource.setPassword(h2Properties.getPassword());
        dataSource.setMaximumPoolSize(h2Properties.getMaxPoolSize());
        dataSource.setMinimumIdle(h2Properties.getMinimumIdle());

        return dataSource;
    }
}
