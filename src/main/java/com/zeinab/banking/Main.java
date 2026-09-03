package com.zeinab.banking;

import com.zeinab.banking.model.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Customer customer=new Customer(
                "C001",
                "Zeinab",
                "Srour",
                "zeinab@example.com"
        );
        BankAccount savings = new SavingsAccount(
                "SAV-001",
                customer
        );

        BankAccount current = new CurrentAccount(
                "CUR-001",
                customer,
                new BigDecimal("500.00")
        );

        savings.deposit(new BigDecimal("1000.00"));
        current.deposit(new BigDecimal("1000.00"));

        savings.withdraw(new BigDecimal("900.00"));
        current.withdraw(new BigDecimal("1200.00"));

        System.out.println("Savings balance: " + savings.getBalance());
        System.out.println("Current balance: " + current.getBalance());

    }
}