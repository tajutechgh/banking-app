package com.tajutechgh.banking.mapper;

import com.tajutechgh.banking.dto.AccountDto;
import com.tajutechgh.banking.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(accountDto.id(), accountDto.accountHolderName(), accountDto.accountBalance());

        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(account.getId(), account.getAccountHolderName(), account.getAccountBalance());

        return accountDto;
    }
}