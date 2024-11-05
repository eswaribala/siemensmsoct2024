package com.siemens.orderservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.javafaker.Faker;
import com.siemens.orderservice.models.Order;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderPublisher {

    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate;

    @Value("${topicname}")
    private String topicName;

    public CompletableFuture<SendResult<Object, Object>> publishMessage(Order order) throws JsonProcessingException {
        Faker faker=new Faker();
        order.setOrderId(faker.random().nextInt(100,10000));
        order.setOrderDate(faker.date().birthday(5,60).toString());

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(order);
        return  kafkaTemplate.send(topicName,json);

    }

}
