package com.boa.customerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name="Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_Id")
    private long customerId;
    @Embedded
    private FullName name;
    @Column(name="Email",nullable = false,length = 150)
    private String email;
    @Column(name="Contact_No")
    private long contactNo;
    @Column(name="Password",nullable = false,length = 10)
    private String password;
}
