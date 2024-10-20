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
        return this.userAccountRepository.findAll();
    }

    @Override
    public UserAccount getUserAccountById(String userId) {
        return this.userAccountRepository.findById(userId).orElse(null);
    }

    @Override
    public UserAccount updateUserAccount(String userId, String email) {
        UserAccount userAccount=getUserAccountById(userId);
        if(userAccount!=null){
            userAccount.setEmail(email);
            return this.userAccountRepository.save(userAccount);
        }else
           return null;
    }

    @Override
    public boolean deleteUserAccount(String userId) {
        boolean status=false;
        UserAccount userAccount=getUserAccountById(userId);
        if(userAccount!=null){
           this.userAccountRepository.deleteById(userId);
           status=true;
        }
           return status;
    }
}
