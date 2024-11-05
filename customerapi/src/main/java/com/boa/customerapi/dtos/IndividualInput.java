package com.boa.customerapi.dtos;

import com.boa.customerapi.models.FullName;
import com.boa.customerapi.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndividualInput {
    private long customerId;

    private FullNameInput name;

    private String email;

    private long contactNo;

    private String password;

    private LocalDate dob;

    private Gender gender;
}
