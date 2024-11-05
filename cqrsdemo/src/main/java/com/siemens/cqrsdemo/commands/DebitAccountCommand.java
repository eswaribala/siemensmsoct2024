package com.siemens.cqrsdemo.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitAccountCommand {
    @TargetAggregateIdentifier
    private String accountId;
    private BigDecimal amount;
}
