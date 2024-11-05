package com.siemens.cqrsdemo.controllers;

import com.siemens.cqrsdemo.models.AccountSummary;
import com.siemens.cqrsdemo.projections.AccountProjector;
import com.siemens.cqrsdemo.projections.FindAccountQuery;
import com.siemens.cqrsdemo.repositories.AccountSummaryRepository;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/accounts")
public class QueryController {
    private final QueryGateway queryGateway;
    @Autowired
    private AccountProjector accountProjector;

    public QueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{accountId}")
    public CompletableFuture<AccountSummary> getAccount(@PathVariable String accountId) {
        return queryGateway.query(new FindAccountQuery(accountId), AccountSummary.class);
    }

    @GetMapping("/{accountId}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "accountId") String accountId){
        return accountProjector.listEventsForAccount(accountId);
    }
}
