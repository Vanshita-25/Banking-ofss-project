package com.ofss.main.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Current;
import com.ofss.main.repository.AccountRepository;
import com.ofss.main.repository.CurrentRepository;
import com.ofss.main.repository.AccountRepositoryImpl;
import com.ofss.main.repository.CurrentRepositoryImpl;
import com.ofss.main.Service.CurrentService;

public class CurrentServiceImpl implements CurrentService {

    private CurrentRepository currentRepository = new CurrentRepositoryImpl();
    private AccountRepository accountRepository = new AccountRepositoryImpl();


    @Override
    public boolean addNewCurrentAccount(Current current) {
        Account account = new Account(current.getcustomer(), "CURRENT");
        int accountId = accountRepository.createNewAccount(account);
        current.setAccountId(accountId);
        return  currentRepository.addNewCurrentAccount(current); 
    }

}