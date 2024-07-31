package com.ofss.main.Service;
import com.ofss.main.domain.Account;
import com.ofss.main.domain.Savings;
import com.ofss.main.repository.AccountRepository;
import com.ofss.main.repository.SavingsRepository;
import com.ofss.main.repository.AccountRepositoryImpl;
import com.ofss.main.repository.SavingsRepositoryImpl;
import com.ofss.main.Service.SavingService;

public class SavingServiceImpl implements SavingService{
    private SavingsRepository savingsRepository = new SavingsRepositoryImpl();
    private AccountRepository accountRepository = new AccountRepositoryImpl();

    @Override
    public boolean addNewSavingsAccount(Savings savings) {
        Account account = new Account(savings.getcustomer(), "SAVINGS");
        int accountId = accountRepository.createNewAccount(account);
        savings.setAccountId(accountId);
        return savingsRepository.addNewSavingsAccount(savings);
    }

}

