package com.siemens.useraccountapi.dtos;

import lombok.Data;

@Data
public class UserAccountResponse<T> {

    private T object;
    private String message;

    public UserAccountResponse(T object) {
        this.object = object;
    }

    public UserAccountResponse(String message) {
        this.message = message;
    }
}
