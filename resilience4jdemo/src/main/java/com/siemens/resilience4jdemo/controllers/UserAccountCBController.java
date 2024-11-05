package com.siemens.resilience4jdemo.controllers;

import com.siemens.resilience4jdemo.services.UserAccountCBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountCBController {
    @Autowired
    private UserAccountCBService userAccountCBService;

    @GetMapping("/useraccounts/v1.0")
    public String getUserDetails(){
        return this.userAccountCBService.getUserAccounts();
    }

}
