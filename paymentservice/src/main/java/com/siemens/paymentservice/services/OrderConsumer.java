package com.siemens.paymentservice.services;

import com.google.gson.Gson;
import com.siemens.paymentservice.models.Order;
import com.siemens.paymentservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "siemensorderoct2024", groupId = "saga-ecommerce-group")

public class OrderConsumer {

    @Autowired
    private OrderRepository orderRepository;

    @KafkaHandler(isDefault = true)

    public void receiveMessage(String message){
        System.out.println(message);

        //json to java object
        Gson gson=new Gson();
       Order order= gson.fromJson(message, Order.class);
       orderRepository.save(order);
        System.out.println("Stored to Mongo.....");

    }

}
