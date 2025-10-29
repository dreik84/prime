package org.example;

import java.util.List;

public class PrimeApp {
    public static void main(String[] args) {

        List<Integer> primeNumbers = Prime.generate(1000);

        System.out.println(primeNumbers);
        System.out.println(primeNumbers.size());
    }
}
