package com.boa.customerapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullNameInput {


    private String firstName;

    private String lastName;

    private String middleName;
}
