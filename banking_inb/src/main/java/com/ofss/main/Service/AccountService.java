package com.ofss.main.Service;

import java.util.List;

import com.ofss.main.domain.Account;

public interface AccountService {
    int createNewAccount (Account account);
    List<Account> getAccountsbyCustomerId(int customerId);
    int withdrawMoney();
    int depositMoney();

}
