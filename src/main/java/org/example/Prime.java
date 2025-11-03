package org.example;

import java.util.ArrayList;
import java.util.List;

public class Prime {
    public static List<Integer> primeNumbers;

    private Prime() {
        throw new AssertionError();
    }

    public static boolean check(int num) {
        if (num < 2) throw new IllegalArgumentException("Illegal number argument " + num);

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public static List<Integer> generate(int bound) {
        primeNumbers = new ArrayList<>(bound >>> 2);

        for (int i = 2; i < bound; i++) {
            if (check(i)) primeNumbers.add(i);
        }

        return primeNumbers;
    }

    public static boolean checkFast(int num) {
        if (num < 2) throw new IllegalArgumentException("Illegal number argument " + num);

        for (int i = 0; primeNumbers.get(i) * primeNumbers.get(i) <= num; i++) {

            if (num % primeNumbers.get(i) == 0) return false;
        }

        return true;
    }

    public static List<Integer> generateFast(int bound) {
        List<Integer> res = new ArrayList<>(bound >>> 2);

        for (int i = 2; i < bound; i++) {
            if (checkFast(i)) res.add(i);
        }

        return res;
    }

    public static List<Integer> generateWithCache(int bound) {
        List<Integer> cache = new ArrayList<>(bound >>> 2);
        cache.add(2);

        for (int i = 3; i < bound; i++) {
            boolean isPrime = true;

            for (int j = 0; cache.get(j) * cache.get(j) <= i; j++) {

                if (i % cache.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) cache.add(i);
        }

        return cache;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static List<Integer> generatePrimes(int bound) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;

        while (num <= bound) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }

        return primes;
    }
}
