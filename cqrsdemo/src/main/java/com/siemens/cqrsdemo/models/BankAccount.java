package com.siemens.cqrsdemo.models;

import com.siemens.cqrsdemo.commands.CreateAccountCommand;
import com.siemens.cqrsdemo.commands.CreditAccountCommand;
import com.siemens.cqrsdemo.commands.DebitAccountCommand;
import com.siemens.cqrsdemo.events.AccountCreatedEvent;
import com.siemens.cqrsdemo.events.AccountCreditedEvent;
import com.siemens.cqrsdemo.events.AccountDebitedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;

import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
public class BankAccount {
    @AggregateIdentifier
    private String accountId;
    private BigDecimal balance;

    @CommandHandler
    public BankAccount(CreateAccountCommand command) {
        apply(new AccountCreatedEvent(command.getAccountId(), command.getInitialBalance()));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        this.accountId = event.getAccountId();
        this.balance = event.getInitialBalance();
    }

    @CommandHandler
    public void handle(CreditAccountCommand command) {
        apply(new AccountCreditedEvent(command.getAccountId(), command.getAmount()));
    }

    @EventSourcingHandler
    public void on(AccountCreditedEvent event) {
        this.balance = this.balance.add(event.getAmount());
    }

    @CommandHandler
    public void handle(DebitAccountCommand command) {
        if (this.balance.compareTo(command.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        apply(new AccountDebitedEvent(command.getAccountId(), command.getAmount()));
    }

    @EventSourcingHandler
    public void on(AccountDebitedEvent event) {
        this.balance = this.balance.subtract(event.getAmount());
    }
}
