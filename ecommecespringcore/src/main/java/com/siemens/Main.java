package com.siemens;

import com.siemens.models.CreditCard;
import com.siemens.models.Order;
import com.siemens.models.UserAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("ecommerce-config.xml");
        applicationContext.registerShutdownHook();

        //Credit Card Instance
        //IOC
        //CreditCard creditCard= (CreditCard) applicationContext.getBean("creditCard");
        //System.out.println(creditCard);

        //create user account
        UserAccount userAccount= (UserAccount) applicationContext
                .getBean("userAccount");

        System.out.println(userAccount);

        UserAccount userAccount1=(UserAccount) applicationContext
                .getBean("userAccount");
        userAccount1.setAccountNo(123);
        //singleton
        System.out.println(userAccount);

        Order order= (Order) applicationContext.getBean("order");
        System.out.println(order.getPayment().makePayment(4236564));


    }
}