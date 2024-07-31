package com.ofss.main.repository;

import java.util.List;

import com.ofss.main.domain.Account;

public interface AccountRepository {
    int createNewAccount (Account account);
    List<Account> getAccountsbyCustomerId(int customerId);
    int withdrawMoney();
    int depositMoney();
}
