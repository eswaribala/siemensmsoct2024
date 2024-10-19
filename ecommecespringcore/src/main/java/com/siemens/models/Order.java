package com.siemens.models;

import com.siemens.facades.Payment;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class Order {
    @Autowired
    @Qualifier(value = "upiPayment")
    private Payment payment;
}
