package org.example;

import java.util.List;

public class PrimeApp {
    public static void main(String[] args) {
        int bound = 10_000_000;

        long start = System.currentTimeMillis();

        List<Integer> primeNumbers = Prime.generate(bound);

        long end = System.currentTimeMillis();

        System.out.println(primeNumbers);
        System.out.println("Count: " + primeNumbers.size());
        System.out.println("Time: " + (end - start) + " ms");
    }
}
