package com.siemens.models;

import com.siemens.facades.Payment;
import org.springframework.stereotype.Component;

@Component
public class WalletPayment implements Payment {
    @Override
    public String makePayment(int amount) {
        return "Payment Done using Wallet...";
    }
}
