package com.siemens.models;

import com.siemens.facades.Payment;
import org.springframework.stereotype.Component;

@Component("upiPayment")
public class UPIPayment implements Payment {
    @Override
    public String makePayment(int amount) {
        return "Payment Done using UPI...";
    }
}
