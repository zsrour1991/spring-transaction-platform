package com.zeinab.banking;

import com.zeinab.banking.exception.InsufficientBalanceException;
import com.zeinab.banking.model.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        try {
            current.withdraw(new BigDecimal("5000.00"));

        }catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Savings balance: " + savings.getBalance());
        System.out.println("Current balance: " + current.getBalance());
        Customer customer1 = new Customer(
                "C001",
                "Zeinab",
                "Srour",
                "z1@example.com"
        );

        Customer customer2 = new Customer(
                "C001",
                "Other",
                "Name",
                "z2@example.com"
        );

        System.out.println(customer1 == customer2);
        System.out.println(customer1.equals(customer2));

        Set<String> a=new HashSet<>();
        a.add("a12");
        a.add("a13");
        a.add("a12");
        System.out.println("Size of a: "+a.size());

        Map<String,BankAccount> accountMap=new HashMap<>();
        accountMap.put("SAV-001",savings);
        accountMap.put("CUR-001",current);
        BankAccount findBankAccount=accountMap.get("SAV-001");
        System.out.println("Find Account"+findBankAccount.getBalance());
        

    }
}