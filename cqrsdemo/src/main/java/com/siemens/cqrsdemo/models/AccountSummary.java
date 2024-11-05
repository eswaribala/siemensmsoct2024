package com.siemens.cqrsdemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AccountSummary")
public class AccountSummary  implements Serializable {
    @Id
    private String accountId;
    private BigDecimal balance;
    // Adds the specified amount to the balance
    public void credit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    // Subtracts the specified amount from the balance
    public void debit(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }
}
