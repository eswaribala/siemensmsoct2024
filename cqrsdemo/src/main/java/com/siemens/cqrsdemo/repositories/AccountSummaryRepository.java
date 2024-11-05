package com.siemens.cqrsdemo.repositories;

import com.siemens.cqrsdemo.models.AccountSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountSummaryRepository extends JpaRepository<AccountSummary, String> {}
