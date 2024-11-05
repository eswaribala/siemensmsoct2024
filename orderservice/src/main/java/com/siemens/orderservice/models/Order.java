package com.siemens.orderservice.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    @Schema(hidden = true)
    private long orderId;
    private long orderAmount;
    @Schema(hidden = true)
    private String orderDate;
}
