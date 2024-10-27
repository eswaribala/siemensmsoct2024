package com.siemens.useraccountapi.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.repository.configuration.EnableVaultRepositories;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(VaultConfiguration.class)
public class DbConfiguration {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String driverName;

    private DataSourceBuilder dataSourceBuilder;
    private final VaultConfiguration vaultConfiguration;

    public DbConfiguration (VaultConfiguration vaultConfig)
    {

        this.vaultConfiguration=vaultConfig;
    }


    @Bean
    public DataSource getDataSource()
    {
        System.out.println(url);
        System.out.println(driverName);

        System.out.println("Entering Given Env.....");
        System.out.println("User Name..."+vaultConfiguration.getUsername());
        System.out.println("Password..."+vaultConfiguration.getPassword());
        //System.out.println("User Name..."+vaultConfiguration.getUsername1());
        //System.out.println("Password..."+vaultConfiguration.getPassword1());
        dataSourceBuilder=DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(vaultConfiguration.getUsername());
        dataSourceBuilder.password(vaultConfiguration.getPassword());
        dataSourceBuilder.driverClassName(driverName);
        return dataSourceBuilder.build();

    }
}
