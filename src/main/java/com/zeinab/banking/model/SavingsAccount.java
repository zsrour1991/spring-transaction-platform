package com.zeinab.banking.model;

import java.math.BigDecimal;

public class SavingsAccount extends  Account{
    public SavingsAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        super.withdraw(amount);
    }
}
