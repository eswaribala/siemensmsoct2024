package com.siemens.useraccountapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="User_Account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(generator = "user-id")
    @GenericGenerator(name="user-id",strategy = "com.siemens.useraccountapi.models.CustomUserIdGenerator")
    @Column(name="User_Id")
    private String userId;
    @Embedded
    private FullName fullName;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="Email",nullable = false,length = 150)
    @Email(message = "Enter valid mail address")
    private String email;

    @Column(name="Password",nullable = false,length = 10)
    @NotNull
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{5,10}$",message = "Password must have mininum one digit,one lowercase and one upper case")
    private String password;

    @Column(name="DOB")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dob;



}
