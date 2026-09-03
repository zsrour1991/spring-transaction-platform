package com.zeinab.banking.model;

import com.zeinab.banking.exception.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account implements BankAccount{

    private String accountNumber;
    private Customer customer;
    private BigDecimal balance;
    private final List<Transaction>transactions;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = BigDecimal.ZERO;
        this.transactions=new ArrayList<>();
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }

        balance = balance.add(amount);

        transactions.add(
                new Transaction(
                        UUID.randomUUID().toString(),
                        TransactionType.DEPOSIT,
                        amount
                )
        );
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InsufficientBalanceException("Withdrawal amount must be greater than zero");
        }

        if (amount.compareTo(balance) > 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        balance = balance.subtract(amount);
        transactions.add(
                new Transaction(
                        UUID.randomUUID().toString(),
                        TransactionType.WITHDRAWAL,
                        amount
                )
        );
    }
    protected void changeBalance(BigDecimal newBalance) {
        this.balance = newBalance;
    }

    protected void addTransaction(
            TransactionType type,
            BigDecimal amount
    ) {
        transactions.add(
                new Transaction(
                        UUID.randomUUID().toString(),
                        type,
                        amount
                )
        );
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}