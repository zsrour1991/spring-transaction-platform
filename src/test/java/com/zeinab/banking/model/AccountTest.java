package com.zeinab.banking.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {

    @Test
    void shouldDepositMoney() {
        Customer customer = new Customer(
                "C001",
                "Zeinab",
                "Srour",
                "z@example.com"
        );

        BankAccount account = new SavingsAccount(
                "ACC-001",
                customer
        );

        account.deposit(new BigDecimal("1000.00"));

        assertEquals(
                new BigDecimal("1000.00"),
                account.getBalance()
        );
    }

    @Test
    void shouldRejectWithdrawalWhenBalanceIsInsufficient() {
        Customer customer = new Customer(
                "C001",
                "Zeinab",
                "Srour",
                "z@example.com"
        );

        BankAccount account = new SavingsAccount(
                "ACC-001",
                customer
        );

        account.deposit(new BigDecimal("100.00"));

        assertThrows(
                RuntimeException.class,
                () -> account.withdraw(new BigDecimal("500.00"))
        );
    }
}