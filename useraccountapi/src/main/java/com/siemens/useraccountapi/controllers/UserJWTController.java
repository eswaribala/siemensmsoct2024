package com.siemens.useraccountapi.controllers;

import com.siemens.useraccountapi.dtos.GenericResponse;
import com.siemens.useraccountapi.dtos.JwtUserSignUpRequest;
import com.siemens.useraccountapi.dtos.UserAccountRequest;
import com.siemens.useraccountapi.models.FullName;
import com.siemens.useraccountapi.models.User;
import com.siemens.useraccountapi.models.UserAccount;
import com.siemens.useraccountapi.services.UserJWTService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJWTController {
    @Autowired
    private UserJWTService userJWTService;

    @PostMapping("signup/v1.0")
    public ResponseEntity<GenericResponse> saveUser(@Valid @RequestBody JwtUserSignUpRequest jwtUserSignUpRequest){
        //DTO to Model

        User user=User.builder()
                .userName(jwtUserSignUpRequest.getUserName())
                .password(jwtUserSignUpRequest.getPassword())
                .build();



        User userInstance=this.userJWTService.addUser(user);
        if(userInstance!=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new GenericResponse(userInstance));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new GenericResponse("User Not Created.... " +
                            "because of invalid data"));

    }
}
