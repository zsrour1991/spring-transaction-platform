package com.zeinab.banking.memory;

public class StackOverflowDemo {

    public static void main(String[] args) {
        recurse();
    }

    private static void recurse() {
        recurse();
    }
}