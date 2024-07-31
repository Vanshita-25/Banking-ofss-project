package com.ofss.main.Service;

import java.util.List;

import com.ofss.main.domain.Account;
import com.ofss.main.repository.AccountRepository;
import com.ofss.main.repository.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository = new AccountRepositoryImpl();

    @Override
    public int createNewAccount(Account account) {
        return accountRepository.createNewAccount(account);
    }

    @Override
    public List<Account> getAccountsbyCustomerId(int customerId) {
        return accountRepository.getAccountsbyCustomerId(customerId);
    }

    @Override
    public int withdrawMoney() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdrawMoney'");
    }

    @Override
    public int depositMoney() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depositMoney'");
    }

}
