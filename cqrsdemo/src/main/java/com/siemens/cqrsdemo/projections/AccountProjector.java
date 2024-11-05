package com.siemens.cqrsdemo.projections;

import com.siemens.cqrsdemo.models.AccountSummary;
import com.siemens.cqrsdemo.events.AccountCreatedEvent;
import com.siemens.cqrsdemo.events.AccountCreditedEvent;
import com.siemens.cqrsdemo.events.AccountDebitedEvent;
import com.siemens.cqrsdemo.repositories.AccountSummaryRepository;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class AccountProjector {

    private final Map<String, AccountSummary> accountSummaryMap = new ConcurrentHashMap<>();

    @Autowired
    private EventStore eventStore;

    private final AccountSummaryRepository repository;

    public AccountProjector(AccountSummaryRepository repository) {
        this.repository = repository;
    }
    @EventHandler

    public void on(AccountCreatedEvent event) {
        repository.save(new AccountSummary(event.getAccountId(), event.getInitialBalance()));
    }

    @EventHandler

    public void on(AccountCreditedEvent event) {
        AccountSummary summary = repository.findById(event.getAccountId()).orElseThrow();
        summary.credit(event.getAmount());
        repository.save(summary);
    }

    @EventHandler

    public void on(AccountDebitedEvent event) {
        AccountSummary summary = repository.findById(event.getAccountId()).orElseThrow();
        summary.debit(event.getAmount());
        repository.save(summary);
    }

    public List<Object> listEventsForAccount(String accountId) {
        return eventStore.readEvents(accountId).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
    }
    @QueryHandler
    public Optional<AccountSummary> handle(FindAccountQuery query) {
        return repository.findById(query.getAccountId());
    }

}
