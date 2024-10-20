package com.siemens.useraccountapi.repositories;

import com.siemens.useraccountapi.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface  UserAccountRepository  extends JpaRepository<UserAccount, String> {

    @Query("from UserAccount u where u.email=:email")
    public List<UserAccount> findUserAccountByEmail(@Param("email") String email);
}
