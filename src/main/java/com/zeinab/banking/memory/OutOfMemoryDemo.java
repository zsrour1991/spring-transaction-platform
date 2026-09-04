package com.zeinab.banking.memory;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryDemo {

    public static void main(String[] args) {

        List<byte[]> allocations = new ArrayList<>();

        while (true) {
            allocations.add(new byte[1024 * 1024]);
        }
    }
}