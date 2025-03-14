/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author ariel
 */
@Configuration
@ComponentScan(basePackages = "edu.gti.asd.ariel.recordkeeping")
@PropertySource("classpath:application.properties")
public class GTIRecordKeepingConfig {
    
    @Value("${db.connection.driver}")
    private String driver;
    
    @Value("${db.connection.url}")
    private String url;
    
    @Value("${db.connection.username}")
    private String username;
    
    @Value("${db.connection.password}")
    private String password;
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        System.out.println("dataSource");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
}
