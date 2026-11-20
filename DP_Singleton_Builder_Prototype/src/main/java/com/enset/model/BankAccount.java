package com.enset.model;

public class BankAccount {
        private Long accountId;
        private double balance;
        private String currency;
        private AccountType type;
        private AccountStatus status;
//        private Customer customer;

        public BankAccount() {}

        public BankAccount(Long accountId, double balance, String currency, AccountType type, AccountStatus status) {
            this.accountId = accountId;
            this.balance = balance;
            this.currency = currency;
            this.type = type;
            this.status = status;
        }

        // Getters & Setters
        public Long getAccountId() { return accountId; }
        public void setAccountId(Long accountId) { this.accountId = accountId; }
        public double getBalance() { return balance; }
        public void setBalance(double balance) { this.balance = balance; }
        public String getCurrency() { return currency; }
        public void setCurrency(String currency) { this.currency = currency; }
        public AccountType getType() { return type; }
        public void setType(AccountType type) { this.type = type; }
        public AccountStatus getStatus() { return status; }
        public void setStatus(AccountStatus status) { this.status = status; }
//        public Customer getCustomer() { return customer; }
//        public void setCustomer(Customer customer) { this.customer = customer; }

        @Override
        public String toString() {
            return "BankAccount{accountId=" + accountId + ", balance=" + balance +
                    ", currency='" + currency + "', type=" + type +
                    ", status=" + status + ", customer=" + customer + '}';
        }
}
