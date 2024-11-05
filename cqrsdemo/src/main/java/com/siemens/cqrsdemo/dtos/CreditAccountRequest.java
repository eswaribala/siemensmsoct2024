package com.siemens.cqrsdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditAccountRequest {
    private String accountId;
    private BigDecimal amount;

}
