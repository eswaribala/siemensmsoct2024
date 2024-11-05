package com.siemens.resilience4jdemo.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UserAccountCBService {

    @Autowired
    private RestClient restClient;
    @Value("${serviceUrl}")
    private String serviceUrl;
    @Value("${alternativeServiceUrl}")
    private String alternativeUrl;


    @CircuitBreaker(name = "gatewayCircuitBreaker", fallbackMethod = "fallback")
    @Retry(name = "gatewayRetry")
    @RateLimiter(name="gatewayRateLimiter")
    public String  getUserAccounts(){
        log.info("Entering actual api call ....");
        return  restClient.get()
                .uri(serviceUrl)
                .retrieve()
                .body(String.class);

    }

    public String fallback(Exception e){
        log.info("Entering Fallback method @="+ LocalDateTime.now() + e.getMessage());
        return  restClient.get()
                .uri(alternativeUrl)
                .retrieve()
                .body(String.class);
    }


}


