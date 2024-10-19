package com.siemens;

import com.siemens.models.CreditCard;
import com.siemens.models.UserAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("ecommerce-config.xml");
        //Credit Card Instance
        //IOC
        //CreditCard creditCard= (CreditCard) applicationContext.getBean("creditCard");
        //System.out.println(creditCard);

        //create user account
        UserAccount userAccount= (UserAccount) applicationContext
                .getBean("userAccount");

        System.out.println(userAccount);


    }
}