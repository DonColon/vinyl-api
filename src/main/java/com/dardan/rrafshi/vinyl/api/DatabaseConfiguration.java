package com.dardan.rrafshi.vinyl.api;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dardan.rrafshi.commons.crypto.Passwords;


@Configuration
@PropertySource(value= {"classpath:application.properties"})
public class DatabaseConfiguration
{
    @Autowired
    private Environment environment;


    @Bean
    public DataSource datasource()
    	throws PropertyVetoException
    {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(this.environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(this.environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(Passwords.getPasswordFromFile("database"));
        return dataSource;
    }
}
