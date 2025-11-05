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

        start = System.currentTimeMillis();

        List<Integer> fastPrimeNumbers = Prime.generateFast(bound);

        end = System.currentTimeMillis();

        System.out.println("Count: " + fastPrimeNumbers.size());
        System.out.println("Time: " + (end - start) + " ms");

        start = System.currentTimeMillis();

        List<Integer> cachePrimeNumbers = Prime.generateWithCache(bound);

        end = System.currentTimeMillis();

        System.out.println("Count: " + cachePrimeNumbers.size());
        System.out.println("Time: " + (end - start) + " ms");

        start = System.currentTimeMillis();

        List<Integer> primes = Prime.generatePrimes(bound);

        end = System.currentTimeMillis();

        System.out.println("Count: " + primes.size());
        System.out.println("Time: " + (end - start) + " ms");

        start = System.currentTimeMillis();

        List<Integer> sievePrimes = Prime.generateSieve(bound);

        end = System.currentTimeMillis();

        System.out.println("Count: " + sievePrimes.size());
        System.out.println("Time: " + (end - start) + " ms");
    }
}
