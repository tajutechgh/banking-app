package com.tajutechgh.banking.service.implementation;

import com.tajutechgh.banking.dto.AccountDto;
import com.tajutechgh.banking.entity.Account;
import com.tajutechgh.banking.mapper.AccountMapper;
import com.tajutechgh.banking.repository.AccountRepository;
import com.tajutechgh.banking.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountImplementation implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);

        account = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

        account.setAccountBalance(account.getAccountBalance() + amount);

        account = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getAccountBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setAccountBalance(account.getAccountBalance() - amount);

        account = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {

        List<Account> accounts = accountRepository.findAll();

        return accounts.stream().map((account -> AccountMapper.mapToAccountDto(account))).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

        accountRepository.delete(account);
    }
}