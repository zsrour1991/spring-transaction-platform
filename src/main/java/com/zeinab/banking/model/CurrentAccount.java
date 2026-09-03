package com.zeinab.banking.model;

import java.math.BigDecimal;

public class CurrentAccount extends Account {

    private final BigDecimal overdraftLimit;

    public CurrentAccount(
            String accountNumber,
            Customer customer,
            BigDecimal overdraftLimit
    ) {
        super(accountNumber, customer);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        BigDecimal availableAmount = getBalance().add(overdraftLimit);

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero"
            );
        }

        if (amount.compareTo(availableAmount) > 0) {
            throw new IllegalArgumentException(
                    "Overdraft limit exceeded"
            );
        }

        changeBalance(getBalance().subtract(amount));
        addTransaction(TransactionType.WITHDRAWAL, amount);
    }
}