package com.boa.customerapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInput {

    private long customerId;

    private FullNameInput name;

    private String email;

    private long contactNo;

    private String password;
}
