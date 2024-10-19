package com.siemens.models;

import com.siemens.facades.Payment;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Data
@Component
public class Order {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    @Qualifier(value = "upiPayment")
    private Payment payment;

    public String getUsers(){
        return this.restTemplate
                .getForObject("https://jsonplaceholder.typicode.com/users",String.class);

    }
}
