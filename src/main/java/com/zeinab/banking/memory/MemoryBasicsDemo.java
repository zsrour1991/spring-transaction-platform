package com.zeinab.banking.memory;

import com.zeinab.banking.model.Customer;

public class MemoryBasicsDemo {

    public static void main(String[] args) {

        int age = 35;

        Customer customer = new Customer(
                "C100",
                "Zeinab",
                "Srour",
                "memory@example.com"
        );

        printCustomer(customer);

        System.out.println("Age: " + age);
    }

    private static void printCustomer(Customer customer) {
        System.out.println(customer.getFirstName());
    }
}