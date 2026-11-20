package com.enset;


import com.enset.model.BankAccount;
import com.enset.repository.AccountRepositoryImpl;
import com.enset.util.JsonSerializer;

import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws IOException {
        JsonSerializer<BankAccount> serializer = new JsonSerializer<>();
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();

        for (int i = 0; i < 10; i++) {
            new Thread(accountRepository::populateData).start();
        }
        System.out.print("Appuyez sur Entrée une fois les threads terminés...");
        System.in.read();

        List<BankAccount> bankAccounts = accountRepository.findAll();
        bankAccounts.stream()
                .map(serializer::toJson)
                .forEach(System.out::println);
    }
}
