package com.siemens.useraccountapi.services;

import com.siemens.useraccountapi.models.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount addUserAccount(UserAccount userAccount);
    List<UserAccount> getAllUserAccounts();
    UserAccount getUserAccountById(String userId);

    UserAccount updateUserAccount(String userId, String email);

    boolean deleteUserAccount(String userId);

}
