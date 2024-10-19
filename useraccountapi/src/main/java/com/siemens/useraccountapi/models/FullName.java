package com.siemens.useraccountapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullName {
    @Column(name="First_Name",nullable = false,length = 50)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First Name must contain only alphabets")
    private String firstName;

    @Column(name="Last_Name",nullable = false,length = 50)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name must contain only alphabets")

    private String lastName;
}
