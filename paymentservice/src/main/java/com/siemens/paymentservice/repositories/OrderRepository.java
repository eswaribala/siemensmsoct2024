package com.siemens.paymentservice.repositories;

import com.siemens.paymentservice.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,Long> {
}
