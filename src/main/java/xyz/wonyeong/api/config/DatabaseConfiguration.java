package xyz.wonyeong.api.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/database.properties")
public class DatabaseConfiguration {

    @Value("${database.DB_URL}")
    private String DB_URL;

    @Value("${database.DB_USERNAME}")
    private String DB_USERNAME;

    @Value("${database.DB_PASSWORD}")
    private String DB_PASSWORD;

    @Bean
    DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(DB_URL);
        dataSourceBuilder.username(DB_USERNAME);
        dataSourceBuilder.password(DB_PASSWORD);
        return dataSourceBuilder.build();
    }
}
