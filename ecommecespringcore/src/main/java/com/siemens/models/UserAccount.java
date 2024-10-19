package com.siemens.models;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component

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
}
