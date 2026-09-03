package com.zeinab.banking.model;

import java.math.BigDecimal;
import java.util.List;

public interface BankAccount {

    void deposit(BigDecimal amount);

    void withdraw(BigDecimal amount);

    BigDecimal getBalance();

    List<Transaction> getTransactions();
}