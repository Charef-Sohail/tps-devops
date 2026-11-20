package com.enset;

import com.enset.model.*;

public class TestPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        BankAccount account1 = BankDirector.accountBuilder()
                .accountId(1L)
                .balance(5000)
                .currency("MAD")
                .type(AccountType.SAVING_ACCOUNT)
                .status(AccountStatus.ACTIVATED)
                .build();
        account1.setCustomer(new Customer(1L, "Mohamed"));

        BankAccount account3 = account1.clone();

        System.out.println("Avant modification :");
        System.out.println("ACC1 : " + account1);
        System.out.println("ACC3 : " + account3);

        account1.getCustomer().setName("Hassan");

        System.out.println("\nAprès modification du Customer de ACC1 :");
        System.out.println("ACC1 : " + account1);
        System.out.println("ACC3 : " + account3);

    }
}
