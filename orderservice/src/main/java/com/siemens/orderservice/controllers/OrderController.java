package com.siemens.orderservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.siemens.orderservice.models.Order;
import com.siemens.orderservice.services.OrderPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderPublisher orderPublisher;

    private String message;

    @PostMapping("/v1.0")
    public CompletableFuture<ResponseEntity<String>> publishOrderDetails(@RequestBody Order order) throws JsonProcessingException {

        return  orderPublisher.publishMessage(order)
                .thenApply(result->ResponseEntity.status(HttpStatus.OK)
                        .body(result.getRecordMetadata().topic()+","+result.getRecordMetadata().partition()+","+result.getRecordMetadata().offset()))
                .exceptionally(ex-> {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
                });
    }


}
