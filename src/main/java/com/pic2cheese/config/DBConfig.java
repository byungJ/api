package com.pic2cheese.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mariadb.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost:3306/bitai?severTimezone=UTC&useSSL=false");

        dataSource.setUsername("bitai");
        dataSource.setPassword("456123");

        return dataSource;

    }

}
