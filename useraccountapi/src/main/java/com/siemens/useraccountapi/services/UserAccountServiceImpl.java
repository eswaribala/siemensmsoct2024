package com.siemens.useraccountapi.services;

import com.siemens.useraccountapi.models.UserAccount;
import com.siemens.useraccountapi.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService{
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Override
    public UserAccount addUserAccount(UserAccount userAccount) {
        if(userAccount!=null)
            return this.userAccountRepository.save(userAccount);
        else
            return null;
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return null;
    }

    @Override
    public UserAccount getUserAccountById(String userId) {
        return null;
    }

    @Override
    public UserAccount updateUserAccount(String userId, String email) {
        return null;
    }

    @Override
    public boolean deleteUserAccount(String userId) {
        return false;
    }
}
