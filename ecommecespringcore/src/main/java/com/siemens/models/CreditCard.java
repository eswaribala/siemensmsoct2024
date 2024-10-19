package com.siemens.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CreditCard {
    private long cardNo;
    private LocalDate expiryDate;
    private int cvvNo;
    private CardType cardType;

}
