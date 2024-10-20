package com.siemens.useraccountapi.controllers;

import com.siemens.useraccountapi.dtos.GenericResponse;
import com.siemens.useraccountapi.dtos.UserAccountRequest;
import com.siemens.useraccountapi.models.FullName;
import com.siemens.useraccountapi.models.UserAccount;
import com.siemens.useraccountapi.services.UserAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("useraccounts")
@Validated
public class UserController {
    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/v1.0")
    public ResponseEntity<GenericResponse> saveUserAccount(@Valid @RequestBody UserAccountRequest userAccountRequest){
           //DTO to Model
        UserAccount userAccount=UserAccount.builder()
                .fullName(FullName.builder()
                        .firstName(userAccountRequest.getFullName().getFirstName())
                        .lastName(userAccountRequest.getFullName().getLastName())
                        .build())
                .dob(userAccountRequest.getDob())
                .email(userAccountRequest.getEmail())
                .password(userAccountRequest.getPassword())
                .gender(userAccountRequest.getGender())
                .build();

        UserAccount userAccountInstance=this.userAccountService.addUserAccount(userAccount);
        if(userAccountInstance!=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new GenericResponse(userAccountInstance));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new GenericResponse("User Account Not Created.... " +
                            "because of invalid data"));

    }
}
