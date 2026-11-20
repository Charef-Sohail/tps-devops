package com.enset;


import com.enset.model.BankAccount;
import com.enset.repository.AccountRepositoryImpl;
import com.enset.util.JsonSerializer;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        JsonSerializer<BankAccount> serializer = new JsonSerializer<>();
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();

        accountRepository.populateData();
        List<BankAccount> bankAccounts = accountRepository.findAll();
        bankAccounts.stream()
                .map(serializer::toJson)
                .forEach(System.out::println);
    }
}
