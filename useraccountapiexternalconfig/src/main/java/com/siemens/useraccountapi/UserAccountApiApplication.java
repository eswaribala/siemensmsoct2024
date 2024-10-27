package com.siemens.useraccountapi;

import com.siemens.useraccountapi.configurations.VaultConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties(VaultConfiguration.class)
public class UserAccountApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserAccountApiApplication.class, args);
    }

}
