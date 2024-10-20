package com.siemens.useraccountapi.repositories;

import com.siemens.useraccountapi.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  UserAccountRepository  extends JpaRepository<UserAccount, String> {
}
