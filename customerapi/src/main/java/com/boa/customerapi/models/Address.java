package com.boa.customerapi.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name="Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Address_Id")
    private long addressId;
    @Column(name="Door_No",nullable = false,length = 5)
    private String doorNo;
    @Column(name="Street_Name",nullable = false,length = 150)
    private  String streetName;
    @Column(name="City",nullable = false,length = 150)
    private String city;
    @Column(name="Pincode")
    private long pincode;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "Customer_Id"),
            name = "Customer_Id")
    private Customer customer;


}
