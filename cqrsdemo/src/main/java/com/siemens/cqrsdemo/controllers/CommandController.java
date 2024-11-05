package com.siemens.cqrsdemo.controllers;

import com.siemens.cqrsdemo.commands.CreateAccountCommand;
import com.siemens.cqrsdemo.commands.CreditAccountCommand;
import com.siemens.cqrsdemo.commands.DebitAccountCommand;
import com.siemens.cqrsdemo.dtos.CreateAccountRequest;
import com.siemens.cqrsdemo.dtos.CreditAccountRequest;
import com.siemens.cqrsdemo.dtos.DebitAccountRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
@RestController
@RequestMapping("/commands")
public class CommandController {

    private final CommandGateway commandGateway;

    public CommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequest request) {
        return commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(), request.getInitialBalance()));
    }

    @PostMapping("/credit")
    public CompletableFuture<Void> creditAccount(@RequestBody CreditAccountRequest request) {
        return commandGateway.send(new CreditAccountCommand(request.getAccountId(), request.getAmount()));
    }

    @PostMapping("/debit")
    public CompletableFuture<Void> debitAccount(@RequestBody DebitAccountRequest request) {
        return commandGateway.send(new DebitAccountCommand(request.getAccountId(), request.getAmount()));
    }


}
