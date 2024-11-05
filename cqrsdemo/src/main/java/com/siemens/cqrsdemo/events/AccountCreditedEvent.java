package com.siemens.cqrsdemo.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreditedEvent {
    private String accountId;
    private BigDecimal amount;
}
