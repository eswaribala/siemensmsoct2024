package com.siemens.paymentservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "orders")
public class Order {
    @BsonId
    private long orderId;
    private long orderAmount;
    private String orderDate;
}
