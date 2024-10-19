package com.siemens.models;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class UserAccount {
    private long accountNo;
    private String name;
    @Autowired
    //dependency injection
    private CreditCard creditCard;

    @PostConstruct
    public void initMethod(){
        this.accountNo=56723;
    }

    @PreDestroy
    public void beforeDestroy(){

        System.out.println("It's about to dispose the bean, close all the files/connections....");

    }

    @Bean
    //converting java object to bean
    public RestTemplate getInstance(){
        return new RestTemplate();
    }
}
